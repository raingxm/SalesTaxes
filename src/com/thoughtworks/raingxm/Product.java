package com.thoughtworks.raingxm;

import java.util.ArrayList;

public class Product {
	private String name;
	private int amount;
	private double price;
	private boolean isImported;
	
	private static ArrayList<String> foods = new ArrayList<String>();
	
	public Product(String name, int amount, double price) {
		this.name = name;
		this.amount = amount;
		this.price = price;
		this.isImported = false;
	}
	
	public ArrayList<String> getAllFoods() {
		return this.foods;
	}
	
	public String getProductName() {
		return this.name;
	}
	
	public int getProductAmount() {
		return this.amount;
	}
	
	public Double getProductPrice() {
		return this.price;
	}
	
	public void addToFoods() {
		foods.add(this.getProductName());
	}
}
