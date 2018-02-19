package com.ubs.data;

import java.math.BigDecimal;
import java.util.Map;

import com.ubs.convertors.ICurrencyConvertor;

public interface IDataBuilder {

	
	void setCurrencyConvertor(ICurrencyConvertor convertor);
	
	Map<GroupKey, BigDecimal> build();
	
}
