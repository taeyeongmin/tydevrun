package com.kh.devrun.community.model.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kh.devrun.community.model.vo.Community;
import com.kh.devrun.community.model.vo.CommunityComment;
import com.kh.devrun.community.model.vo.CommunityCommentEntity;
import com.kh.devrun.community.model.vo.CommunityEntity;
import com.kh.devrun.report.model.vo.Report;

@Repository
public class CommunityDaoImpl implements CommunityDao {

	@Autowired
	private SqlSession session;
	
	@Override
	public int insertColumn(Community community) {
		return session.insert("community.insertColumn", community);
	}

	@Override
	public List<Community> selectColumnList() {
		return session.selectList("community.selectColumnList");
	}

	@Override
	public List<Community> columnBestList() {
		return session.selectList("community.columnBestList");
	}

	@Override
	public int insertFreeboard(Community community) {
		return session.insert("community.insertFreeboard", community);
	}

	@Override
	public List<CommunityEntity> selectFreeboardList(int offset, int limit) {
		// mybatis가 제공하는 RowBounds 객체를 하나 제공한다. -- 페이징 처리를 위해서
		RowBounds rowBounds = new RowBounds(offset, limit);
		return session.selectList("community.selectFreeboardList", null, rowBounds);
	}

	@Override
	public int selectFreeboardTotalCount() {
		return session.selectOne("community.selectFreeboardCount");
	}

	@Override
	public CommunityEntity selectOneCommunity(int communityNo) {
		return session.selectOne("community.selectOneCommunity", communityNo);
	}

	@Override
	public List<CommunityCommentEntity> selectCommentList(int communityNo) {
		return session.selectList("community.selectCommentList", communityNo);
	}

	// 댓글 등록
	@Override
	public int insertComment(CommunityComment communityComment) {
		return session.insert("community.insertComment", communityComment);
	}

	@Override
	public int commentDelete(int commentNo) {
		return session.delete("community.commentDelete", commentNo);
	}

	@Override
	public int updateCommunity(CommunityEntity communityEntity) {
		return session.update("community.updateCommunity", communityEntity);
	}

	@Override
	public int communityDelete(int communityNo) {
		return session.delete("community.communityDelete", communityNo);
	}

	@Override
	public int viewCount(int communityNo) {
		return session.update("community.viewCount", communityNo);
	}

	@Override
	public List<CommunityEntity> selectFreeboardListByType(Map<String, Object> param, int offset, int limit) {
		// mybatis가 제공하는 RowBounds 객체를 하나 제공한다. -- 페이징 처리를 위해서
		RowBounds rowBounds = new RowBounds(offset, limit);
		return session.selectList("community.selectFreeboardListByType", param, rowBounds);
	}

	@Override
	public int selectFreeboardTotalCountByType(Map<String, Object> param) {
		return session.selectOne("community.selectFreeboardTotalCountByType", param);
	}

	@Override
	public int didIHitLikes(Map<String, Object> param) {
		return session.selectOne("community.didIHitLikes", param);
	}

	@Override
	public int freeboardLikeAdd(Map<String, Object> param) {
		return session.update("community.freeboardLikeAdd", param);
	}

	@Override
	public int refreshCountLikes(int communityNo) {
		return session.selectOne("community.refreshCountLike", communityNo);
	}

	@Override
	public int freeboardLikeDelete(Map<String, Object> param) {
		return session.update("community.freeboardLikeDelete", param);
	}

	@Override
	public int insertCommunity(CommunityEntity communityEntity) {
		return session.insert("community.insertCommunity", communityEntity);
	}

	@Override
	public int insertQna(Community community) {
		return session.insert("community.insertQna", community);
	}

	@Override
	public int insertStudy(Community community) {
		return session.insert("community.insertStudy", community);
	}

	@Override
	public int insertMemberCommunityLike(Map<String, Object> param) {
		return session.insert("community.insertMemberCommunityLike", param);
	}

	@Override
	public int deleteMemberCommunityLike(Map<String, Object> param) {
		return session.delete("community.deleteMemberCommunityLike", param);
	}

	@Override
	public int insertCommunityWriteEnroll(Community community) {
		return session.insert("community.insertCommunityWriteEnroll", community);
	}

	@Override
	public int insertCommunityReport(Report report) {
		return session.insert("community.insertCommunityReport", report);
	}

	@Override
	public List<CommunityEntity> selectLikeBoardList(Map<String, Object> param, int offset, int limit) {
		// mybatis가 제공하는 RowBounds 객체를 하나 제공한다. -- 페이징 처리를 위해서
		RowBounds rowBounds = new RowBounds(offset, limit);
		return session.selectList("community.selectLikeBoardList", param, rowBounds);
	}

	@Override
	public List<CommunityEntity> selectCommentBoardList(Map<String, Object> param, int offset, int limit) {
		// mybatis가 제공하는 RowBounds 객체를 하나 제공한다. -- 페이징 처리를 위해서
		RowBounds rowBounds = new RowBounds(offset, limit);
		return session.selectList("community.selectCommentBoardList", param, rowBounds);
	}

	// 스터디 리스트
	@Override
	public List<CommunityEntity> selectStudyList(int offset, int limit) {
		// mybatis가 제공하는 RowBounds 객체를 하나 제공한다. -- 페이징 처리를 위해서
		RowBounds rowBounds = new RowBounds(offset, limit);
		return session.selectList("community.selectStudyList", null, rowBounds);
	}

	@Override
	public int selectOneStudyCount() {
		return session.selectOne("community.selectStudyCount");
	}
	
	/**
	 * 지원 dao 시작
	 */
	
	@Override
	public List<CommunityEntity> selectAllPostOrderByLatest(int memberNo, int offset, int limit) {
		RowBounds rowBounds = new RowBounds(offset, limit);
		return session.selectList("community.selectAllPostOrderByLatest", memberNo, rowBounds);
	}

	@Override
	public int selectPostTotalCount(int memberNo) {
		return session.selectOne("community.selectPostTotalCount", memberNo);
	}

	@Override
	public List<CommunityEntity> selectPostTotalCount(Map<String, Object> param, int offset, int limit) {
		RowBounds rowBounds = new RowBounds(offset, limit);
		return session.selectList("community.selectPostTotalCount", param, rowBounds);
	}

	/**
	 * 지원 dao 끝
	 */
}
