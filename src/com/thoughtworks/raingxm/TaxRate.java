package com.thoughtworks.raingxm;

public class TaxRate {
	private int taxRateAsPercent;
	
	public TaxRate() {
		taxRateAsPercent = 0;
	}
	
	public int getRateAsPercentage() {
		return this.taxRateAsPercent;
	}

	public void addTaxRateBy(int rateToAdd) {
		this.taxRateAsPercent += rateToAdd;
	}

	public static double rounding(double amount) {
		int taxMutiByHundred = (int) Math.round(amount * 100);
		int roundingTaxMutiByHundred = (taxMutiByHundred / 10) * 10;
		if(taxMutiByHundred % 10 != 0) {
			roundingTaxMutiByHundred += Math.max(taxMutiByHundred % 10, 5);
		}
		return (double) (roundingTaxMutiByHundred / 100.0);
	}

	public double rateFor(double price) {
		double taxForPrice = taxRateAsPercent * price / 100.0;
		return rounding(taxForPrice);
	}
}
