package com.kh.devrun.promotion.model.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kh.devrun.product.model.vo.ProductEntity;
import com.kh.devrun.promotion.model.vo.Promotion;

@Repository
public class PromotionDaoImpl implements PromotionDao {
	
	@Autowired
	private SqlSession session;
	
	@Override
	public List<ProductEntity> selectProductListByProductCode(String searchCode) {
		return session.selectList("product.selectProductListByProductCode", searchCode);
	}

	@Override
	public int insertPromotion(Promotion promotion) {
		return session.insert("promotion.insertPromotion", promotion);
	}

	@Override
	public int insertProductPromotion(List<Map<String, Object>> list) {
		return session.insert("promotion.insertProductPromotion", list);
	}


	@Override
	public List<Promotion> selectAllPromotionList() {
		return session.selectList("promotion.selectAllPromotionList");
	}

	@Override
	public Promotion selectPromotionWithProductByPromotionCode(String promotionCode) {
		return session.selectOne("promotion.selectPromotionWithProductByPromotionCode", promotionCode);
	}


	@Override
	public int updatePromotion(Promotion promotion) {
		return session.update("promotion.updatePromotion", promotion);
	}

	@Override
	public int deleteProductPromotion(List<Map<String, Object>> deleteProductList) {
		return session.delete("promotion.deleteProductPromotion", deleteProductList);
	}

	@Override
	public int deletePromotion(String[] promotionCode) {
		return session.delete("promotion.deletePromotion", promotionCode);
	}

	@Override
	public List<ProductEntity> selectProductListByPromotionCode(Map<String, Object> param) {
		return session.selectList("promotion.selectProductListByPromotionCode", param);
	}

	@Override
	public List<Promotion> selectCurrentPromotionList() {
		return session.selectList("promotion.selectCurrentPromotionList");
	}

	@Override
	public List<Promotion> selectEndPromotionList() {
		return session.selectList("promotion.selectEndpromotionList");
	}

	@Override
	public List<Map<String, String>> selectProductPromotionByPromotionCode(String promotionCode) {
		return session.selectList("promotion.selectProductPromotionByPromotionCode", promotionCode);
	}

	@Override
	public List<ProductEntity> selectProductPromotionListByChildCategoryCode(Map<String, Object> param) {
		return session.selectList("promotion.selectProductPromotionListByChildCategoryCode", param);
	}

	@Override
	public List<Map<String, Object>> selectProductNameAndCodeByPromotionCode(String promotionCode) {
		return session.selectList("promotion.selectProductNameAndCodeByPromotionCode", promotionCode);
	}

	@Override
	public int updateViewCount(String promotionCode) {
		return session.update("promotion.updateViewCount", promotionCode);
	}

	@Override
	public Promotion selectPromotionByPromotionCode(String promotionCode) {
		return session.selectOne("promotion.selectPromotionByPromotionCode", promotionCode);
	}

	@Override
	public List<ProductEntity> selectProductListByPromotionCode(Map<String, Object> param, int offset, int limit) {
		RowBounds rowBounds = new RowBounds(offset, limit);
		return session.selectList("promotion.selectProductListByPromotionCode", param, rowBounds);
	}

	@Override
	public int selectProductTotalCount(Map<String, Object> param) {
		return session.selectOne("promotion.selectProductTotalCount", param);
	}

	/**
	 * 지원 dao 시작
	 */
	
	@Override
	public Promotion selectOneLatestPromotionBanner() {
		return session.selectOne("promotion.selectOneLatestPromotionBanner");
	}

	@Override
	public List<Promotion> selectThreeCurrentPromotion() {
		return session.selectList("promotion.selectThreeCurrentPromotion");
	}
	
	@Override
	public List<ProductEntity> selectPromotionProductList1(String promotionCode1) {
		return session.selectList("promotion.selectPromotionProductList1", promotionCode1);
	}

	@Override
	public List<ProductEntity> selectPromotionProductList2(String promotionCode2) {
		return session.selectList("promotion.selectPromotionProductList2", promotionCode2);
	}

	@Override
	public List<ProductEntity> selectPromotionProductList3(String promotionCode3) {
		return session.selectList("promotion.selectPromotionProductList3", promotionCode3);
	}

	/**
	 * 지원 dao 끝
	 */

}
