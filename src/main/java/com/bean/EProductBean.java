package com.bean;


public class EProductBean {
	
	private Integer productId;
	private String productName;
	private String category;
	private Float price;
	private String qty;
	private String productImagePath;
	
	
	public String getProductImagePath() {
		return productImagePath;
	}

	public void setProductImagePath(String productImagePath) {
		this.productImagePath = productImagePath;
	}

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}
	
	public void setProductName(String productName) {
		this.productName = productName;
	}
	
	public String getCategory() {
		return category;
	}
	
	public void setCategory(String category) {
		this.category = category;
	}
	
	public Float getPrice() {
		return price;
	}
	
	public void setPrice(Float price) {
		this.price = price;
	}
	
	public String getQty() {
		return qty;
	}
	
	public void setQty(String qty) {
		this.qty = qty;
	}
	
}
