package com.kh.devrun.admin.model.dao;

import java.util.List;
import java.util.Map;

import com.kh.devrun.category.model.vo.ProductChildCategory;
import com.kh.devrun.product.Product;
import com.kh.devrun.product.ProductCategory;
import com.kh.devrun.product.ProductDetail;
import com.kh.devrun.product.ProductExtends;
import com.kh.devrun.promotion.model.vo.Promotion;

public interface AdminDao {

	List<ProductChildCategory> selectChildCategory(Map<String, Object> param);

	int insertProduct(Product product);

	int insertProducCategory(ProductCategory productCategory);
	
	int insertProductDetail(ProductDetail productDetail);
	
	List<ProductExtends> selectAllProductList();
	
	
	/**
	 * 태영 끝-----------------------------------
	 */
	
	
	/**
	 * 혜진 시작
	 * @param searchCode
	 * @return
	 */
	List<Product> selectProductListByProductCode(String searchCode);
	
	int insertPromotion(Promotion promotion);
	
	int insertProductPromotion(List<Map<String, Object>> list);
	
	List<Promotion> selectAllPromotionList();
	
	Promotion selectPromotionByPromotionCode(String promotionCode);
	
	int updatePromotion(Promotion promotion);
	
	int deleteProductPromotion(List<Map<String, Object>> deleteProductList);
	
	int deletePromotion(String[] promotionCode);
	
	List<Product> selectProductListByPromotionCode(String promotionCode);
	/**
	 * 혜진 끝
	 */




	







}
