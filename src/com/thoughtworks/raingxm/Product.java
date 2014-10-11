package com.thoughtworks.raingxm;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Product {
	private String name;
	private int num;
	private double price;
	private boolean isImported;
	
	private static ArrayList<String> food = new ArrayList<String>();
	private static ArrayList<String> medicalProducts = new ArrayList<String>();
	private static ArrayList<String> books = new ArrayList<String>();
	
	public Product(String name, int num, double price, boolean isImported) {
		this.name = name;
		this.num = num;
		this.price = price;
		this.isImported = isImported;
	}
	
	public String getProductName() {
		return this.name;
	}
	
	public int getProductNum() {
		return this.num;
	}
	
	public double getProductPrice() {
		return this.price;
	}
	
	public boolean isImported() {
		return this.isImported;
	}

	public static ArrayList<String> getAllFood() {
		return food;
	}
	
	public static ArrayList<String> getAllMedicalProducts() {
		return medicalProducts;
	}
	
	public static ArrayList<String> getAllBooks() {
		return books;
	}
	
	public static Product createProductByProductInfo(String inputProductInfo) {
		String productName = getProductNameByInfo(inputProductInfo);
		boolean isImported = judeProductImportedOrNotByInfo(inputProductInfo);
		int productNum = getProductNumByInfo(inputProductInfo);
		double price = getProductPriceByInfo(inputProductInfo);
		return new Product(productName, productNum, price, isImported);
	}
	
	public static void addFoodByName(String foodName) {
		food.add(foodName);
	}
	
	public static void addMedicalProductsByName(String medicineName) {
		medicalProducts.add(medicineName);
	}
	
	public static void addBookByName(String bookName) {
		books.add(bookName);
	}

	protected static String getProductNameByInfo(String inputProductInfo) {
		int startIndex = inputProductInfo.indexOf(" ") + 1;
		int endIndex = inputProductInfo.lastIndexOf("at") - 1;
		return inputProductInfo.substring(startIndex, endIndex);
	}

	protected static int getProductNumByInfo(String inputProductInfo) {
		int endIndex = inputProductInfo.indexOf(" ");
		return Integer.parseInt(inputProductInfo.substring(0, endIndex));
	}

	protected static boolean judeProductImportedOrNotByInfo(String inputProductInfo) {
		
		return inputProductInfo.indexOf("imported") != -1;
	}

	protected static double getProductPriceByInfo(String inputProductInfo) {
		Pattern pattern = Pattern.compile("((\\d+)\\.(\\d+))");
		Matcher m = pattern.matcher(inputProductInfo);
		if(m.find()) {
			return Double.parseDouble(m.group(0));
		}
		return 0.0;
	}
}
