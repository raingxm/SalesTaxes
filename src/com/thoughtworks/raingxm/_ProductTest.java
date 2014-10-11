package com.thoughtworks.raingxm;

import java.util.ArrayList;

import org.hamcrest.core.Is;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.matchers.JUnitMatchers.*;


public class _ProductTest {
	
	@Test
	public void couldAddTheProductIntoFoodProducts() {
		assertThat(Product.getAllFood(), hasItem("chocolate"));
	}
	
	@Test
	public void couldAddTheProductIntoMedicalProducts() {
		assertThat(Product.getAllMedicalProducts(), hasItem("headache pills"));
	}
	
	@Test 
	public void couldAddBookToBooksByName() {
		assertThat(Product.getAllBooks(), hasItem("book"));
	}
	
	@Test
	public void getProductNameFromTheInputProductInfo() {
		assertThat(Product.getProductNameByInfo("1 book at 12.49"), is("book"));
		assertThat(Product.getProductNameByInfo("1 imported box of chocolates at 10.00"), is("imported box of chocolates"));
		assertThat(Product.getProductNameByInfo("1 packet of hadache pills at 9.75"), is("packet of hadache pills"));
	}
	
	@Test
	public void getProductNumFromTheInputProductInfo() {
		assertThat(Product.getProductNumByInfo("1 book at 12.49"), is(1));
		assertThat(Product.getProductNumByInfo("2 boxes of imported chocolates at 22.50"), is(2));
		assertThat(Product.getProductNumByInfo("3 music CD at 44.97"), is(3));
	}
	
	@Test
	public void judeAProductIsImportedOrNotFromTheInputProductInfo() {
		assertThat(Product.judeProductImportedOrNotByInfo("1 book at 12.49"), is(false));
		assertThat(Product.judeProductImportedOrNotByInfo("1 imported box of chocolates at 10.00"), is(true));
	}
	
	@Test
	public void getProductPriceFromTheInputProductInfo() {
		assertThat(Product.getProductPriceByInfo("1 imported box of chocolates at 10.00"), is(10.00));
		assertThat(Product.getProductPriceByInfo("1 music CD at 14.99"), is(14.99));
		assertThat(Product.getProductPriceByInfo("1 packet of headache pills at 9.75"), is(9.75));
	}
	
	@Test
	public void createAProductByTheInputProductInfo() {
		Product product = Product.createProductByProductInfo("1 imported box of chocolates at 10.03");
		assertThat(product.getProductName(), is("imported box of chocolates"));
		assertThat(product.isImported(), is(true));
		assertThat(product.getProductPrice(), is(10.03));
		assertThat(product.getProductNum(), is(1));
	}
	
	@Test 
	public void couldJudeAProductType() {
		couldJudeMedicalProduct();
		couldJudeFoodProduct();
		couldJudeBookProduct();
	}
	
    @Test
    public void productTaxRateIsSetProperly() {
    	Product perfume = Product.createProductByProductInfo("1 bottle of perfume at 18.99");
    	assertThat(perfume.caculateProductTaxRate().getRateAsPercentage(), is(10));
    	
    	Product pills = Product.createProductByProductInfo("1 packet of headache pills at 9.75");
    	assertThat(pills.caculateProductTaxRate().getRateAsPercentage(), is(0));
    	
    	Product importedChocolates = Product.createProductByProductInfo("1 box of imported chocolates at 11.25");
    	assertThat(importedChocolates.caculateProductTaxRate().getRateAsPercentage(), is(5));
    }
    
    @Test
    public void caculateTaxTheProductToPay() {
    	Product pills = Product.createProductByProductInfo("1 packet of headache pills at 9.75");
    	assertThat(pills.productTaxes(), is(0.0));
    	
    	Product perfume = Product.createProductByProductInfo("1 bottle of perfume at 18.99");
    	assertThat(perfume.productTaxes(), is(1.90));
    	
    	Product importedPerfume = Product.createProductByProductInfo("1 imported bottle of perfume at 47.50");
    	assertThat(importedPerfume.productTaxes(), is(7.15));
    }
    
    @Test 
    public void caculateProductTotalPriceContainsTaxes() {
    	Product book = Product.createProductByProductInfo("1 book at 12.49");
    	assertThat(book.totalPrice(), is(12.49));
    	
    	Product perfume = Product.createProductByProductInfo("1 bottle of perfume at 18.99");
    	assertThat(perfume.totalPrice(), is(20.89));
    	
    }
	
    @Before
    public void addSomeFoodBooksAndMedicine() {
    	Product.addFoodByName("chocolate");
		Product.addBookByName("book");
		Product.addMedicalProductsByName("headache pills");
    }

	private void couldJudeBookProduct() {
		Product book = Product.createProductByProductInfo("1 book at 12.49");
		assertThat(book.isFood(), is(false));
		assertThat(book.isMedicine(), is(false));
		assertThat(book.isBook(), is(true));
	}

	private void couldJudeFoodProduct() {
		Product chocolates = Product.createProductByProductInfo("1 imported box of chocolates at 10.00");
		assertThat(chocolates.isFood(), is(true));
		assertThat(chocolates.isMedicine(), is(false));
		assertThat(chocolates.isBook(), is(false));
	}

	private void couldJudeMedicalProduct() {
		Product pills = Product.createProductByProductInfo("1 packet of headache pills at 9.75");
		assertThat(pills.isFood(), is(false));
		assertThat(pills.isMedicine(), is(true));
		assertThat(pills.isBook(), is(false));
	}
}
