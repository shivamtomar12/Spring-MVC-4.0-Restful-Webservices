package com.spring.web.productweb.sql;

public class SQL {


	public static final String GETPRODUCT = "select * from products p where p.productCode= :productCode";
	public static final String GETPRODUCTS= "select * from products";

			
	public static final String INSERTPRODUCT = "insert  into `products`(`productCode`,`productName`,`productLine`,`productScale`,`productVendor`,`productDescription`,`quantityInStock`,`buyPrice`,`MSRP`)"
			+"values (:productCode,:productName,:productLine,:productScale,:productVendor,:productDescription,:quantityInStock,:buyPrice,:msrp );";
	public static final String UPDATEPRODUCT="update products p set p.productname = :productName where p.productcode = :productCode"; 
	public static final String DELETEPRODUCT="delete from products where productcode = :productCode ";


}
