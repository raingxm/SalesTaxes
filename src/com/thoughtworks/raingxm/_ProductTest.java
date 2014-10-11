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
		Product.addFoodByName("chocolates");
		assertThat(Product.getAllFood(), hasItem("chocolates"));
	}
	
	@Test
	public void couldAddTheProductIntoMedicalProducts() {
		Product.addMedicalProductsByName("pills");
		assertThat(Product.getAllMedicalProducts(), hasItem("pills"));
	}
	
	@Test 
	public void couldAddBookToBooksByName() {
		Product.addBookByName("book");
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
		assertThat(Product.getProductPriceByInfo("1 packet of hadache pills at 9.75"), is(9.75));
	}
	
	@Test
	public void createAProductByTheInputProductInfo() {
		Product product = Product.createProductByProductInfo("1 imported box of chocolates at 10.03");
		assertThat(product.getProductName(), is("imported box of chocolates"));
		assertThat(product.isImported(), is(true));
		assertThat(product.getProductPrice(), is(10.03));
	}
}
