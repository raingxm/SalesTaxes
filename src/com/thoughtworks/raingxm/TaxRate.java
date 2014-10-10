package com.thoughtworks.raingxm;

public class TaxRate {
	private int taxRateAsPercent;
	
	public TaxRate() {
		taxRateAsPercent = 0;
	}
	
	public int getRateAsPercentage() {
		return this.taxRateAsPercent;
	}

	public void addTax(int rateToAdd) {
		this.taxRateAsPercent += rateToAdd;
	}
}
