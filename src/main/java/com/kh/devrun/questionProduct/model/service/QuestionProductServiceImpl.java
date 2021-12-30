package com.kh.devrun.questionProduct.model.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.test.annotation.Rollback;

import com.kh.devrun.questionProduct.exception.insertQuestionProductException;
import com.kh.devrun.questionProduct.model.dao.QuestionProductDao;
import com.kh.devrun.questionProduct.model.vo.QuestionProduct;
import com.kh.devrun.questionProduct.model.vo.QuestionProductEx;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class QuestionProductServiceImpl implements QuestionProductService {
	
	@Autowired
	private QuestionProductDao questionProductDao;

	@Override
	public List<QuestionProduct> selectAllQuestionList() {
		return questionProductDao.selectAllQuestionList();
	}

	@Override
	public QuestionProductEx selectOneQuestionProductInfo(Map<String,Object> param) {
		return questionProductDao.selectOneQuestionProductInfo(param);
	}

	// 상품 문의 답변 1행 추가
	
	@Override
	public int insertQuestionProduct(QuestionProduct questionProduct) {
		
		int result = 0;
		
		try {
			result = questionProductDao.insertQuestionProduct(questionProduct);
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new insertQuestionProductException("상품등록 오류가 발생했습니다.",e);
		}		
		return result;
	}
	
	// 문의 번호를 참조번호로 하는 게시물 가져오기
	@Override
	public QuestionProduct selectQuestionByRefNo(int questionNo) {
		return questionProductDao.selectQuestionByRefNo(questionNo);
	}
	
}
