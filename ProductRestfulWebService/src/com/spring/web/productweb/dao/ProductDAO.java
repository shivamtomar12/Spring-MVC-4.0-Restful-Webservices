package com.spring.web.productweb.dao;

import java.util.List;

import com.spring.web.productweb.model.Product;

public interface ProductDAO {

	public Product getProduct(String productCode);
	
	public List<Product> getProducts();
	
	public int createProduct(Product product);
	
	public int[] createProducts(List<Product> products);
	
	public int updateProduct(Product product);
	
	public int deleteProduct(String productCode);
	
	
	
	
}
