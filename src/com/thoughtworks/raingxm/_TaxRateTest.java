package com.thoughtworks.raingxm;

import org.junit.Test;
import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.*;

public class _TaxRateTest {

	@Test
	public void defaultTaxRateIsZero() {
		TaxRate rate = new TaxRate();
		assertThat(rate.getRateAsPercentage(), is(0));
	}
	
	@Test
	public void addTaxRateIsOk() {
		TaxRate rate = new TaxRate();
		rate.addTax(5);
		assertThat(rate.getRateAsPercentage(), is(5));
		rate.addTax(10);
		assertThat(rate.getRateAsPercentage(), is(15));
	}

}
