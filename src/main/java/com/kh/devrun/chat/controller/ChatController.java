package com.kh.devrun.chat.controller;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.kh.devrun.chat.model.service.ChatService;
import com.kh.devrun.chat.model.vo.ChatLog;
import com.kh.devrun.chat.model.vo.ChatMember;
import com.kh.devrun.common.DevrunUtils;
import com.kh.devrun.member.model.vo.Member;
import com.kh.devrun.report.model.service.ReportService;
import com.kh.devrun.report.model.vo.Report;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@RequestMapping("/chat")
public class ChatController {
	
	@Autowired
	private ChatService chatService;
	
	@Autowired
	private ReportService reportService;
	
	/**
	 * 채팅 접속 - 채팅 리스트 팝업 return
	 */
	@GetMapping("/chatList.do")
	public String chatList(Authentication authentication, Model model) { // model은 MVC의 M이 아니다. View단의 데이터를 전달하기 위한 스프링만의 객체이다. 
		
		// 본인의 채팅 리스트를 불러오기 위한 loginMember 호출
		Member loginMember = (Member) authentication.getPrincipal();
		int memberNo = loginMember.getMemberNo();
		
		List<ChatLog> list = chatService.findChatLog(memberNo);
		log.debug("list = {}", list);
		
		model.addAttribute("list", list);
		
		return "chat/chatListPopup";
		
	}

	/**
	 * 채팅방 접속 - 채팅방 팝업 return
	 */
	@GetMapping("/chatRoom.do/{chatId}")
	public String chatRoom(Authentication authentication, @PathVariable String chatId, Model model) {
		
		model.addAttribute("chatId", chatId); // 이부분 없어도 chatId jsp에서 사용 가능함.
		
		// 채팅로그 조회
		List<ChatLog> list = chatService.findChatLogByChatId(chatId);
		//log.debug("list = {}", list);
		model.addAttribute("list", list);
		
		// 상대 회원의 정보 조회(신고 모달 등 이용하기 위함) - chatId와 로그인한 회원 번호 넘기기
		Member loginMember = (Member) authentication.getPrincipal();
		int memberNo = loginMember.getMemberNo();
		
		Map<String, Object> param = new HashMap<>();
		param.put("memberNo", memberNo);
		param.put("chatId", chatId);

		Member receiver = chatService.selectOneReceiver(param);
		//log.debug("receiver = {}", receiver);
		model.addAttribute("receiver", receiver);
		
		// 로그인한 회원의 chat_member.end_date 조회하여 그 이후 채팅 로그만 보이게 하기 위함 (end_date null인경우 0으로 받아온다.)
		// unix초 받아온다.
		long endDate = chatService.findEndDate(param);
		//log.debug("endDate = {}", endDate);
		model.addAttribute("endDate", endDate);

		return "chat/chatRoomPopup";
	}
	
	/**
	 * 비동기
	 * 회원 닉네임 검색 - 채팅방 생성을 위한 전단계
	 */
	@ResponseBody
	@GetMapping("/searchNickname.do")
	public List<Member> searchNickname(Authentication authentication, @RequestParam(required = false) String searchNickname) {
		// required = false 하면 기본값으로 파라미터를 전달받을 때, 값이 없다면 Exception 없이 코드를 실행시킨다.
		
		// 본인 닉네임 제외한 리스트를 불러오기 위해 loginMember 호출
		Member loginMember = (Member) authentication.getPrincipal();
		String nickname = loginMember.getNickname();
		
		Map<String, Object> param = new HashMap<>();
		param.put("searchNickname", searchNickname);
		param.put("nickname", nickname);
		
		log.debug("searchNickname = {}", searchNickname);
		List<Member> list = chatService.selectAllMemberByNickname(param);
		log.debug("list = {}", list);
		
		return list;
	}
	
	/**
	 * 비동기
	 * 채팅 초대 - 레코드 조회 후 분기 chatId 결과 return
	 */
	@ResponseBody
	@PostMapping("/chat.do")
	public String chat(Authentication authentication, Model model, @RequestParam(required = false) int receiverNo) {
		Member loginMember = (Member) authentication.getPrincipal();
		log.debug("loginMember = {}", loginMember);
		String chatId = null;
		int memberNo = loginMember.getMemberNo();
		
		Map<String, Object> param = new HashMap<>();
		param.put("memberNo", memberNo);
		param.put("receiverNo", receiverNo);
		
		//log.debug("memberNo = {}", memberNo);
		// 1. 채팅방 조회 : chat_member테이블의 해당회원과 상대방 간의 레코드가 있는가
		ChatMember chatSender = chatService.findChatMemberByMemberNo(param);
		log.debug("chatSender = {}", chatSender);
		
		// 2. 첫 접속인 경우 : chat_member테이블에 insert작업
		if(chatSender == null) {
			chatId = DevrunUtils.getRandomChatId();
			log.debug("chatId = {}", chatId);
			chatSender = new ChatMember(chatId, memberNo, receiverNo, 0, null, null, "Y");
			ChatMember chatReceiver = new ChatMember(chatId, receiverNo, memberNo, 0, null, null, "Y");
			chatService.insertChatMembers(Arrays.asList(chatSender, chatReceiver));
		}
		// 3. 이미 접속한 경우 : chatId 조회
		else {
			chatId = chatSender.getChatId();
		}
		
		return chatId;
	}
	
	/**
	 * 비동기
	 * 채팅방 검색 - 닉네임으로 검색
	 */
	@ResponseBody
	@GetMapping("/searchChatRoom.do")
	public List<String> searchChatRoom(Authentication authentication, @RequestParam(required = false) String searchChatRoom){
		Member loginMember = (Member) authentication.getPrincipal();
		int memberNo = loginMember.getMemberNo();
		
		Map<String, Object> param = new HashMap<>();
		param.put("memberNo", memberNo);
		param.put("searchNickname", searchChatRoom);
		
		List<String> chatIdList = chatService.searchChatRoom(param);
		log.debug("chatIdList = {}", chatIdList);
		
		return chatIdList;
	}
	
	/**
	 * 비동기
	 * 채팅방 나가기
	 */
	@ResponseBody
	@PostMapping("/{chatId}/exitChatRoom.do")
	public int exitChatRoom(Authentication authentication, @PathVariable String chatId) {
		Member loginMember = (Member) authentication.getPrincipal();
		int memberNo = loginMember.getMemberNo();
		
		Map<String, Object> param = new HashMap<>();
		param.put("memberNo", memberNo);
		param.put("chatId", chatId);
		
		// db chat_member.end_date update
		int result = chatService.exitChatRoom(param);
		
		return result;
	}
	
	/**
	 * 비동기
	 * 전체안읽음 메시지 건수 조회(헤더, 마이페이지 채팅건수 부분 사용)
	 */
	@ResponseBody
	@GetMapping("/selectMessageTotalUnreadCount.do")
	public int selectMessageTotalUnreadCount(Authentication authentication) {
		Member loginMember = (Member) authentication.getPrincipal();
		int memberNo = loginMember.getMemberNo();
		
		int totalUnreadCount = chatService.selectMessageTotalUnreadCount(memberNo);
		log.debug("totalUnreadCount = {}", totalUnreadCount);
		
		return totalUnreadCount;
	}
	
	/**
	 * 메시지 신고 & 회원 신고
	 */
	@PostMapping("/insertReport.do")
	public String insertReport(Report report, RedirectAttributes redirectAttr, HttpServletRequest request) {
		log.debug("report = {}", report);
		
		try {
			// 신고 등록
			int result = reportService.insertReport(report);
			log.debug("result = {}", result);
			
			redirectAttr.addFlashAttribute("msg", "신고 등록 성공");
			
		} catch (Exception e) {
			log.error("신고 등록 실패", e);
			throw e;
		}
		
		String referer = request.getHeader("Referer");
		return "redirect:" + referer;
	}
	

}
