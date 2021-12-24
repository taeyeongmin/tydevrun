package com.kh.devrun.promotion.model.service;

import java.util.List;
import java.util.Map;

import com.kh.devrun.product.model.vo.Product;
import com.kh.devrun.promotion.model.vo.Promotion;

public interface PromotionService {

	List<Product> selectProductListByProductCode(String searchCode);

	
	int insertPromotion(Map<String, Object> param);


	List<Promotion> selectAllPromotionList();

	Promotion selectPromotionByPromotionCode(String promotionCode);

	int updatePromotion(Map<String, Object> param);

	int deletePromotion(String[] promotionCode);

	List<Product> selectProductListByPromotionCode(String promotionCode);

	Map<String, List<Promotion>> selectDevidedPromotionList();

}
