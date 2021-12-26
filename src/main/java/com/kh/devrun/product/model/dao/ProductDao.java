package com.kh.devrun.product.model.dao;

import java.util.List;
import java.util.Map;

import com.kh.devrun.category.model.vo.ProductChildCategory;
import com.kh.devrun.product.model.vo.Product;
import com.kh.devrun.product.model.vo.ProductCategory;
import com.kh.devrun.product.model.vo.ProductDetail;
import com.kh.devrun.product.model.vo.ProductExtends;

public interface ProductDao {
	List<ProductChildCategory> selectChildCategory(Map<String, Object> param);

	int insertProduct(Product product);

	int insertProducCategory(ProductCategory productCategory);
	
	int insertProductDetail(ProductDetail productDetail);
	
	List<Product>selectAllProductList(int offset, int limit);
	
	int selectTotalBoardCount();

	List<ProductDetail> findProductOption(String productCode);
	
	// 상품삭제
	int deleteProduct(String productCode);

	// 상품정보 하나 가져오기
	ProductExtends selectProductOne(String productCode);
}