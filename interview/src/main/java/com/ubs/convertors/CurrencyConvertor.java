package com.ubs.convertors;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

/**
 * Due to time limit I'm not creating Exchange Rates. Will have to think
 * differently later TODO: ExchangeRate should be class. Explore later
 * 
 * @author abhij
 *
 */

public class CurrencyConvertor implements ICurrencyConvertor {

	private String baseCurrency = "USD";
	private Map<String, Double> exchangeRates = new HashMap<String, Double>();

	public CurrencyConvertor() {

		exchangeRates.put("GBP", 1.654);
		exchangeRates.put("CHF", 1.10);
		exchangeRates.put("EUR", 1.35);
	}

	public CurrencyConvertor(String baseCurrency) {
		this.baseCurrency = baseCurrency;
		exchangeRates.put("GBP", 1.654);
		exchangeRates.put("CHF", 1.10);
		exchangeRates.put("EUR", 1.35);
	}

	public BigDecimal convert(BigDecimal amount, String toCurrency, String fromCurrency) {
		if (baseCurrency.equals(fromCurrency)) {
			return amount.multiply(new BigDecimal(exchangeRates.get(toCurrency)));
		} else {
			BigDecimal multiplier = BigDecimal.ONE.divide(new BigDecimal(exchangeRates.get(fromCurrency)));
			return amount.multiply(multiplier).multiply(new BigDecimal(exchangeRates.get(toCurrency)));
		}

	}

	@Override
	public void setBaseCurrency(String baseCurrency) {
		this.baseCurrency = baseCurrency;

	}
}
