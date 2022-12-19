package com.gl.ods.model;

import org.springframework.stereotype.Component;

public class Product {
	
	private int id;
	private String name;
	private String category;
	private int qty;
	private float price;
	private float buyingPrice;
	public Product() {
		// TODO Auto-generated constructor stub
	}
	public Product(int id, String name, String category, int qty, float price, float buyingPrice) {
		super();
		this.id = id;
		this.name = name;
		this.category = category;
		this.qty = qty;
		this.price = price;
		this.buyingPrice = buyingPrice;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public float getBuyingPrice() {
		return buyingPrice;
	}
	public void setBuyingPrice(float buyingPrice) {
		this.buyingPrice = buyingPrice;
	}
	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", category=" + category + ", qty=" + qty + ", price=" + price
				+ ", buyingPrice=" + buyingPrice + "]";
	}
	
}
