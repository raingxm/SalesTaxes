package com.thoughtworks.raingxm;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.thoughtworks.raingxm.internal.ConsoleExporter;
import com.thoughtworks.raingxm.internal.FileExporter;

public class ShopSeller {
	private ArrayList<Product> products = new ArrayList<Product>();
	private Scanner scanner = new Scanner(System.in);
	private Exporter exporter = new ConsoleExporter();
	
	public ShopSeller() {
		initProducts();
	}
	
	public ShopSeller(Exporter exporter) {
		this.exporter = exporter;
		initProducts();
	}
	
	public ArrayList<Product> getAllProducts() {
		return this.products;
	}
	
	public static void main(String args[]) {
		ShopSeller shop = new ShopSeller();
		shop.addOrderFromInput().addOrderFromInput().addOrderFromInput().addOrderFromInput();
		shop.showDetails();
	}
	
	public void showDetails() {
		DecimalFormat decimalFormat = new DecimalFormat(".00");
		for(Product product : products) {
			exporter.output(product.getProductNum() + " " + 
					product.getProductName() + ":" + decimalFormat.format(product.totalPrice()));
		}	
		exporter.output("Sales Taxes: " + decimalFormat.format(ordersTotalSalesTaxes()));
		exporter.output("TaoTal: " + decimalFormat.format(ordersTotalPrice()));
		exporter.end();
	}
	
	public ShopSeller addOrderFromInput() throws InputProductMessageErrorException{
		String inputOrder = scanner.nextLine();
		addOrderFromInput(inputOrder);
		return this;
	}
	
	public ShopSeller addOrderFromInput(String inputProductInfo) throws InputProductMessageErrorException{
		if(!validateMessageFormat(inputProductInfo)) {
			throw new InputProductMessageErrorException("input message format error, must contains product name" +
					"product price and product num"); 
		}		
		Product product = Product.createProductByProductInfo(inputProductInfo);
		products.add(product);
		return this;
	}
	
	public double ordersTotalPrice() {
		BigDecimal result = new BigDecimal(Double.toString(0.0));
		for(Product product : products) {
			result = result.add(new BigDecimal(Double.toString(product.totalPrice())));
		}
		return result.doubleValue();
	}
	
	public double ordersTotalSalesTaxes() {
		BigDecimal ordersTotalPrice = new BigDecimal(Double.toString(ordersTotalPrice()));
		BigDecimal ordersToalPriceNotContainTaxes = new BigDecimal(Double.toString(ordersToalPriceNotContainTaxes()));
		return ordersTotalPrice.subtract(ordersToalPriceNotContainTaxes).doubleValue();
	}
	
	private void initProducts() {
		initProductsInFood();
		initProductsInMedicialProduct();
		initProductsInBooks();
	}
	private void initProductsInFood() {
		Product.addFoodByName("chocolate");
	}
	
	private void initProductsInMedicialProduct() {
		Product.addMedicalProductsByName("headache pills");
	}
	
	private void initProductsInBooks() {
		Product.addBookByName("book");
	}
	
	private boolean validateMessageFormat(String inputMessage) {
		if(inputMessage.indexOf("at") == -1 || inputMessage.indexOf(" ") == -1 || !messageContainProductPrice(inputMessage))
			return false;
		return  true;
	}
	
	private boolean messageContainProductPrice(String inputMessage) {
		Pattern pattern = Pattern.compile("((\\d+)\\.(\\d+))");
		Matcher m = pattern.matcher(inputMessage);
		if(m.find()) return true;
		return false;
	}
	
	private double ordersToalPriceNotContainTaxes() {
		BigDecimal result = new BigDecimal(Double.toString(0.0));
		for(Product product : products) {
			result = result.add(new BigDecimal(Double.toString(product.getProductPrice())));
		}
		return result.doubleValue();
	}
}
