package com.spring.web.productweb.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="product")
public class Product {
	
	
	private String productCode;
	private String productName;
	private String productLine;
	private String productScale;
	private String productVendor;
	private String productDescription;
	private int quantityInStock;
	private double buyPrice;
	private double msrp;
	
	public Product(){
		
	}
	public Product(String productCode, String productName, String productLine, String productScale,
			String productVendor, String productDescription, int quantityInStock, double buyPrice, double msrp) {
		super();
		this.productCode = productCode;
		this.productName = productName;
		this.productLine = productLine;
		this.productScale = productScale;
		this.productVendor = productVendor;
		this.productDescription = productDescription;
		this.quantityInStock = quantityInStock;
		this.buyPrice = buyPrice;
		this.msrp = msrp;
	}
	
	public String getProductCode() {
		return productCode;
	}
	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getProductLine() {
		return productLine;
	}
	public void setProductLine(String productLine) {
		this.productLine = productLine;
	}
	public String getProductScale() {
		return productScale;
	}
	public void setProductScale(String productScale) {
		this.productScale = productScale;
	}
	public String getProductVendor() {
		return productVendor;
	}
	public void setProductVendor(String productVendor) {
		this.productVendor = productVendor;
	}
	public String getProductDescription() {
		return productDescription;
	}
	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}
	public int getQuantityInStock() {
		return quantityInStock;
	}
	public void setQuantityInStock(int quantityInStock) {
		this.quantityInStock = quantityInStock;
	}
	public double getBuyPrice() {
		return buyPrice;
	}
	public void setBuyPrice(double buyPrice) {
		this.buyPrice = buyPrice;
	}
	public double getMsrp() {
		return msrp;
	}
	public void setMsrp(double msrp) {
		this.msrp = msrp;
	}
	@Override
	public String toString() {
		return "Product [productCode=" + productCode + ", productName=" + productName + ", productLine=" + productLine
				+ ", productScale=" + productScale + ", productVendor=" + productVendor + ", productDescription="
				+ productDescription + ", quantityInStock=" + quantityInStock + ", buyPrice=" + buyPrice + ", msrp="
				+ msrp + "]";
	}



}
