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
		rate.addTaxRateBy(5);
		assertThat(rate.getRateAsPercentage(), is(5));
		rate.addTaxRateBy(10);
		assertThat(rate.getRateAsPercentage(), is(15));
	}
	
	@Test
	public void roundingPriceTaxMatchesTheRoundingRules() {
		TaxRate rate = new TaxRate();
		assertThat(rate.rounding(12.225), is(12.25));
		assertThat(rate.rounding(23.462), is(23.46));
		assertThat(rate.rounding(23.499), is(23.5));
	}

	@Test
	public void caculateTheProductTax() {
		TaxRate rate = new TaxRate();
		rate.addTaxRateBy(10);
		assertThat(rate.rateFor(14.99), is(1.5));
		rate.addTaxRateBy(5);
		assertThat(rate.rateFor(47.50), is(7.15));
	}
}
