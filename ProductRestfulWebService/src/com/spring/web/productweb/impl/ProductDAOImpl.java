package com.spring.web.productweb.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSourceUtils;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.spring.web.productweb.dao.ProductDAO;
import com.spring.web.productweb.model.Product;
import com.spring.web.productweb.sql.SQL;

@Component("productdao")
public class ProductDAOImpl implements ProductDAO {

	private NamedParameterJdbcTemplate jdbc;

	
	public ProductDAOImpl(){
		System.out.println("Inside ProductDAOImpl");
	}
	@Autowired
	public void setDataSource(DataSource jdbc) {
		this.jdbc = new NamedParameterJdbcTemplate(jdbc);
	}

	public Product getProduct(String productCode) {
		System.out.println("Inside getProduct"+productCode);
		MapSqlParameterSource params=new MapSqlParameterSource();
		params.addValue("productCode",productCode);
		
		return (Product) jdbc.queryForObject(SQL.GETPRODUCT,params,new RowMapper<Product>() {

			public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
				Product product=new Product();
				product.setProductCode(rs.getString("ProductCode"));
				product.setBuyPrice(rs.getDouble("BuyPrice"));
				product.setMsrp((rs.getDouble("msrp")));
				product.setProductDescription((rs.getString("productDescription")));
				product.setProductLine((rs.getString("productLine")));
				product.setProductName(rs.getString("productName"));
				product.setProductScale(rs.getString("productScale"));
				product.setProductVendor(rs.getString("productVendor"));
				product.setQuantityInStock(rs.getInt("quantityInStock"));

				return product;
				
			}
		});
	}

	public List<Product> getProducts() {

		return jdbc.query(SQL.GETPRODUCTS, new RowMapper<Product>() {

			public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
				Product product=new Product();
				product.setProductCode(rs.getString("ProductCode"));
				product.setBuyPrice(rs.getDouble("BuyPrice"));
				product.setMsrp((rs.getDouble("msrp")));
				product.setProductDescription((rs.getString("productDescription")));
				product.setProductLine((rs.getString("productLine")));
				product.setProductName(rs.getString("productName"));
				product.setProductScale(rs.getString("productScale"));
				product.setProductVendor(rs.getString("productVendor"));
				product.setQuantityInStock(rs.getInt("quantityInStock"));

				return product;
			}

		});


	}

	public int createProduct(Product product) {
		BeanPropertySqlParameterSource params=new BeanPropertySqlParameterSource(product);
		/*MapSqlParameterSource params=new MapSqlParameterSource();
		params.addValue("productCode",product.getProductCode());
		params.addValue("productName",product.getProductName());
		params.addValue("productLine",product.getProductLine());
		params.addValue("productScale",product.getProductScale());
		params.addValue("productVendor",product.getProductVendor());
		params.addValue("productDesc",product.getProductDescription());
		params.addValue("productQuantity",product.getQuantityInStock());
		params.addValue("productBuyPrice",product.getBuyPrice());
		params.addValue("productMsrp",product.getMsrp());*/
		
		
		return jdbc.update(SQL.INSERTPRODUCT,params);
	}

	public int updateProduct(Product product) {
		MapSqlParameterSource params=new MapSqlParameterSource();
		params.addValue("productCode",product.getProductCode());
		params.addValue("productName",product.getProductName());
		return jdbc.update(SQL.UPDATEPRODUCT,params);
	}

	public int deleteProduct(String productCode) {
		MapSqlParameterSource params=new MapSqlParameterSource();
		params.addValue("productCode",productCode);
		return jdbc.update(SQL.DELETEPRODUCT,params);
	}
	@Transactional
	public int[] createProducts(List<Product> products) {
		SqlParameterSource[] params = SqlParameterSourceUtils.createBatch(products.toArray());
		return jdbc.batchUpdate(SQL.INSERTPRODUCT, params);
	}

}
