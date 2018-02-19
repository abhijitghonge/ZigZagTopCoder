package com.ubs.convertors;

import java.math.BigDecimal;

public interface ICurrencyConvertor {
	BigDecimal convert(BigDecimal amount, String toCurrency, String fromCurrency);
	
	void setBaseCurrency(String baseCurrency);
}
