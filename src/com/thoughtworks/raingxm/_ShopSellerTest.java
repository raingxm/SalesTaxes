package com.thoughtworks.raingxm;

import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.matchers.JUnitMatchers.*;

import org.junit.Ignore;
import org.junit.Test;

public class _ShopSellerTest {
	
	@Test
	public void initProductsInFoodMedicalAndBookThroughConstructor() {
		ShopSeller shopSeller = new ShopSeller();
		assertThat(Product.getAllFood(), hasItem("chocolate"));
		assertThat(Product.getAllBooks(), hasItem("book"));
	}
	
	@Test 
	public void couldAddOrdersByMethodChains() throws Exception{
		ShopSeller shopSeller = new ShopSeller();
		shopSeller.addOrderFromInput("1 box of imported chocolates at 11.25").addOrderFromInput("1 bottle of perfume at 18.99");
		assertThat(shopSeller.getAllProducts().size(), is(2));
	}
	
	@Test
	public void orderFromInputFormatErrorThrowException() {
		ShopSeller shopSeller = new ShopSeller();
		boolean messageFormat = true;
		try {
			shopSeller.addOrderFromInput("1 box of imported chocolates at ");
		} catch (InputProductMessageErrorException messageerror) {
			messageFormat = false;
		}
		assertThat(messageFormat, is(false));
	}
	
	@Test
	public void caculateOrdersTotalPriceAndTotalSalesTaxes() {
		firstInputOrdersTotalPriceOk();
		secondInputOrdersTotalPriceOk();
		thirdInputOrdersTotalPriceOk();
	}
	
	private void firstInputOrdersTotalPriceOk() {
		ShopSeller shopSeller = new ShopSeller();
		shopSeller.addOrderFromInput("1 book at 12.49").addOrderFromInput("1 mousic CD at 14.99").
			addOrderFromInput("1 chocolate bar at 0.85");
		assertThat(shopSeller.ordersTotalPrice(), is(29.83));
		assertThat(shopSeller.ordersTotalSalesTaxes(), is(1.50));
	}
	
	private void secondInputOrdersTotalPriceOk() {
		ShopSeller shopSeller = new ShopSeller();
		shopSeller.addOrderFromInput("1 imported box of chocolates at 10.00").addOrderFromInput("1 imported bottle of perfume at 47.50");
		assertThat(shopSeller.ordersTotalPrice(), is(65.15));
		assertThat(shopSeller.ordersTotalSalesTaxes(), is(7.65));
	}
	
	private void thirdInputOrdersTotalPriceOk() {
		ShopSeller shopSeller = new ShopSeller();
		shopSeller.addOrderFromInput("1 bottle of perfume at 18.99").
				addOrderFromInput("1 imported bottle of perfume at 27.99").
				addOrderFromInput("1 box of imported chocolates at 11.25").
				addOrderFromInput("1 packet of headache pills at 9.75");
		assertThat(shopSeller.ordersTotalPrice(), is(74.68));
		assertThat(shopSeller.ordersTotalSalesTaxes(), is(6.70));
	}
}
