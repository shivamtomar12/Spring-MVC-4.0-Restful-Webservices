package com.spring.web.productweb.test;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataAccessException;

import com.spring.web.productweb.dao.ProductDAO;
import com.spring.web.productweb.model.Product;

public class App {
	public static void main(String[] args) {
		ApplicationContext context=new ClassPathXmlApplicationContext("com/spring/web/productweb/beans/beans.xml");
		ProductDAO productdao=(ProductDAO) context.getBean("productdao");
		
		//Get all products
		try{
			/*for(Product product:productdao.getProducts()){
				System.out.println(product);
			}*/
		}catch(DataAccessException dae)
		{
			System.out.println(dae.getMessage());
			System.out.println(dae.getClass());
		}
		
		
		
		//Get products by productCode
		try{
			System.out.println(productdao.getProduct("shivam"));
		}catch(DataAccessException dae)
		{
			System.out.println(dae.getMessage());
			System.out.println(dae.getClass());
		}

		//('S10_1678','1969 Harley Davidson Ultimate Chopper','Motorcycles','1:10','Min Lin Diecast','Description.',7933,48.81,95.7);";
		Product product1=new Product("Shivam1","Shivam's Product","Motorcycles","Large","God","Shivam's Item",222,12,1212);
		
		
		//Create a Product
		try{
			//productdao.createProduct(product1);
		}catch(DataAccessException dae)
		{
			System.out.println(dae.getMessage());
			System.out.println(dae.getClass());
		}
		
		Product product2=new Product("Shivam10","Shivam's Product","Motorcycles","Large","God","Shivam's Item",222,12,1212);
		
		Product product3=new Product("Shivam9","Shivam's Product","Motorcycles","Large","God","Shivam's Item",222,12,1212);
		
		
		List<Product> products=new ArrayList<Product>();
		products.add(product2);
		products.add(product3);
		//Create a Product
		try{
			/*int[] returnedVals=productdao.createProducts(products);
			for(Integer vals:returnedVals){
				System.out.println("Inserted:"+vals);
			}*/
		}catch(DataAccessException dae)
		{
			System.out.println(dae.getMessage());
			System.out.println(dae.getClass());
		}
		
		//Delete a Product
		try{
//			productdao.deleteProduct("shivam1");
		}catch(DataAccessException dae)
		{
			System.out.println(dae.getMessage());
			System.out.println(dae.getClass());
		}
		
		//Update a Product
		try{
			//product.setProductName("real");
			//productdao.updateProduct(product);
		}catch(DataAccessException dae)
		{
			System.out.println(dae.getMessage());
			System.out.println(dae.getClass());
		}


		((ClassPathXmlApplicationContext)context).close();
	}
}
