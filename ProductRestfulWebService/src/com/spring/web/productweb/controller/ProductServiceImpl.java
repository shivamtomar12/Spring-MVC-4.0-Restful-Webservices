package com.spring.web.productweb.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.spring.web.productweb.model.Product;
import com.spring.web.productweb.model.ProductList;
import com.spring.web.productweb.service.ProductBusinessService;



/**
 * @author Shivam
 *
 *HttpHeaders headers = new HttpHeaders();
		headers.add("Accept", MediaType.APPLICATION_JSON_VALUE);

		HttpEntity entity = new HttpEntity(headers);

		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<String> response = restTemplate.exchange("http://localhost:8080/productweb/productservice/products", HttpMethod.GET, entity,String.class);
		System.out.println(response.getBody()); 
 *
 *
 *
 *
 *
 *
 *
 *
 *
 */
@RestController
@RequestMapping("/productservice")
public class ProductServiceImpl  {


	private ProductBusinessService productBusinessService;

	@Autowired
	public void setProductBusinessService(ProductBusinessService productBusinessService) {
		this.productBusinessService = productBusinessService;
	}


	@RequestMapping(value="/product/{productCode}",method=RequestMethod.GET,produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<Product> getProduct(@PathVariable String productCode) {
		Product productResponse=new Product();
		try{
			productResponse=productBusinessService.getProduct(productCode);
		}catch(Exception e){
			return new ResponseEntity<Product>(HttpStatus.NOT_FOUND);
		}
		if(productCode==null){
			return new ResponseEntity<Product>(HttpStatus.NOT_FOUND);
		}else if(productResponse.getProductCode()==null){
			return new ResponseEntity<Product>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Product>(productResponse,HttpStatus.OK);
	}

	@RequestMapping(value="/products",method=RequestMethod.GET,produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<ProductList> getProducts() {
		//Get products by productCode
		ProductList products=new ProductList();
		try {
			products.setProduct(productBusinessService.getProducts());
		} catch (Exception e) {
			return new ResponseEntity<ProductList>(products,HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<ProductList>(products,HttpStatus.OK);
	}

	@RequestMapping(value="/{product}",method=RequestMethod.POST,headers="Accept=application/xml")
	public ResponseEntity createProduct(@RequestBody Product product) {
		System.out.println(product);
		try {
			productBusinessService.createProduct(product);
		} catch (Exception e) {
			return new ResponseEntity(HttpStatus.NOT_FOUND);

		}
		return new ResponseEntity(HttpStatus.CREATED);
	}
	@RequestMapping(value="/products/{list}",method=RequestMethod.POST,headers="Accept=application/xml")
	public ResponseEntity createProducts(@RequestBody ProductList list) {

		try {
			productBusinessService.createProducts(list.getProduct());
		}  catch (Exception e) {
			return new ResponseEntity(HttpStatus.NOT_FOUND);

		}
		return new ResponseEntity(HttpStatus.CREATED);
	}

	@RequestMapping(value="/{product}",method=RequestMethod.PUT,headers="Accept=application/xml")
	public ResponseEntity updateProduct(@RequestBody Product product) {

		try {
			productBusinessService.updateProduct(product);
		}  catch (Exception e) {
			return new ResponseEntity(HttpStatus.NOT_FOUND);

		}
		return new ResponseEntity(HttpStatus.OK);
	}

	@RequestMapping(value="/product/{productCode}",method=RequestMethod.DELETE,headers="Accept=application/xml")
	public ResponseEntity deleteProduct(@PathVariable String productCode) {
		// TODO Auto-generated method stub
		try {
			productBusinessService.deleteProduct(productCode);
		}   catch (Exception e) {
			return new ResponseEntity(HttpStatus.NOT_FOUND);

		}
		return new ResponseEntity(HttpStatus.CREATED);
	}

}
