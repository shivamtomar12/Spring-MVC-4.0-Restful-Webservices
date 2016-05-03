package com.spring.web.productweb.controller;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.web.productweb.model.Product;
import com.spring.web.productweb.model.ProductList;
//@RestController
//@RequestMapping("/productservice")
public interface ProductService {
	
	//@RequestMapping(value="/product/{productCode}",method=RequestMethod.GET)
	public  Product getProduct(@PathVariable String productCode);
	
	//@RequestMapping(value="/products",method=RequestMethod.GET, produces="application/xml")
	public ProductList getProducts();
	
	
	public boolean createProduct(Product product);
	
	public boolean createProducts(List<Product> products);
	
	public boolean updateProduct(Product product);
	
	public boolean deleteProduct(String productCode);
	
}
