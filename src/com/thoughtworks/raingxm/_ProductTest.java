package com.thoughtworks.raingxm;

import java.util.ArrayList;

import org.junit.Test;
import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.matchers.JUnitMatchers.*;


public class _ProductTest {
	@Test
	public void constructorPerformOk() {
		Product product = new Product("coffee", 2, 15.0);
		assertThat(product.getProductName(), is("coffee"));
		assertThat(product.getProductAmount(), is(2));
		assertThat(product.getProductPrice(), is(15.0));
	}
	
	@Test
	public void couldJudeWhetherAProductIsFoodOrNotByProductName() {
		Product product = new Product("chocolates", 3, 20.5);
		Product product2 = new Product("chocolats", 2, 20.5);
		product.addToFoods();
		assertThat(product.getAllFoods(), hasItem("chocolats"));
	}
}
