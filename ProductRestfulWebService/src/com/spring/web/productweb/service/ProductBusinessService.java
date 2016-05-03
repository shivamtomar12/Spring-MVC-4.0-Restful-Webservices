package com.spring.web.productweb.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.spring.web.productweb.dao.ProductDAO;
import com.spring.web.productweb.model.Product;

@Service("productBusinessService")
public class ProductBusinessService {

	private ProductDAO productDao;

	@Autowired
	public void setProductDao(ProductDAO productDao) {
		this.productDao = productDao;
	}
	public Product getProduct(String productCode) throws Exception{

		//Get products by productCode
		Product product=new Product();
		try{
			product=productDao.getProduct(productCode);
			System.out.println("Inside Product business Service:"+product);
		}catch(DataAccessException dae)
		{
			throw new Exception(dae);
		}
		return product;

	}

	public List<Product> getProducts() throws Exception{
		List<Product> products=new ArrayList<Product>();
		try{
			products=productDao.getProducts();

		}catch(DataAccessException dae)
		{
			throw new Exception(dae);
		}
		return products;
	}
	
	public boolean createProduct(Product product) throws Exception{
		int rowsUpdated=0;
		try{
			rowsUpdated=productDao.createProduct(product);
		}catch(DataAccessException dae)
		{
			throw new Exception(dae);
		}
		return rowsUpdated==1;
		
	}
	
	public boolean createProducts(List<Product> products) throws Exception {
		try{
			productDao.createProducts(products);
		}catch(DataAccessException dae)
		{
			throw new Exception(dae);
		}
		return true;
	}
	

	public boolean updateProduct(Product product) throws Exception {
		int rowsUpdated=0;
		try{
			rowsUpdated=productDao.updateProduct(product);
		}catch(DataAccessException dae)
		{
			throw new Exception(dae);
		}
		return rowsUpdated==1;
	}
	
	public int deleteProduct(String productCode) throws Exception{
		int rowsUpdated=0;
		try{
			rowsUpdated=productDao.deleteProduct(productCode);
		}catch(DataAccessException dae)
		{
			throw new Exception(dae);
		}
		return rowsUpdated;
	}
}
