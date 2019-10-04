package com.cognizant.sharingeconomy.model;

public class Product {

	private String vendorId;
	private String productId;
	private String productName;
	private String category;
	private double price;
	private double stock;

	public String getVendorId() {
		return vendorId;
	}

	public void setVendorId(String vendorId) {
		this.vendorId = vendorId;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
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

	public double getPrice() {
		return price;
	}

	public Product(String productId, String productName, String category, double price, double stock) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.category = category;
		this.price = price;
		this.stock = stock;
	}

	public Product(String vendorId, String productId, String productName, String category, double price, double stock) {
		super();
		this.vendorId = vendorId;
		this.productId = productId;
		this.productName = productName;
		this.category = category;
		this.price = price;
		this.stock = stock;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getStock() {
		return stock;
	}

	public void setStock(double stock) {
		this.stock = stock;
	}

}
