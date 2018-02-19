package com.ubs.data;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import com.ubs.convertors.CurrencyConvertor;
import com.ubs.convertors.ICurrencyConvertor;
import com.ubs.loader.DelimitedFileLoader;

public class CompanyDataBuilder implements IDataListener, IDataBuilder {
	private DelimitedFileLoader fileLoader = null;
	private ICurrencyConvertor convertor = null;
	private String outputCurrency = null;
	
	

	private Map<GroupKey, GroupValue> results = new HashMap<GroupKey, GroupValue>();

	public CompanyDataBuilder(DelimitedFileLoader fileLoader, String baseCurrency, String outputCurrency) {
		this.fileLoader = fileLoader;
		this.convertor = new CurrencyConvertor(baseCurrency);
		this.outputCurrency = outputCurrency;

		fileLoader.registerBuilder(this);
	}

	public CompanyDataBuilder(DelimitedFileLoader fileLoader) {
		this.fileLoader = fileLoader;
		this.convertor = new CurrencyConvertor();

		fileLoader.registerBuilder(this);
	}


	
	public void setCurrencyConvertor(ICurrencyConvertor convertor) {
		this.convertor = convertor;
	}


	public Map<GroupKey, BigDecimal> build() {
		try {
			fileLoader.loadData();
			
		} catch (IOException e) {
			// TODO Need to use some logging framwork. But ok for now
			e.printStackTrace();
		}
		
		Map<GroupKey, BigDecimal> finalResults = new HashMap<GroupKey, BigDecimal>();
		for (Map.Entry<GroupKey, GroupValue> groupEntry : this.results.entrySet()) {
			finalResults.put(groupEntry.getKey(), groupEntry.getValue().computeAverage());
		}
		
		
		return finalResults;
	}

	@Override
	public void notifyDataReady(String[] dataRow) {
		FxAccountBalance balance = new FxAccountBalance();
		int dataFieldCount = 0;
		balance.companyCode = Integer.parseInt(dataRow[dataFieldCount++]);
		balance.accountId = Integer.parseInt(dataRow[dataFieldCount++]);
		balance.city = dataRow[dataFieldCount++];
		balance.country = dataRow[dataFieldCount++];
		balance.creditRating = dataRow[dataFieldCount++];
		balance.issueCurrency = dataRow[dataFieldCount++];
		balance.issueAmount = new BigDecimal(dataRow[dataFieldCount++]);
		
		computeSumAmountInBase(balance);

	}
	
	/**
	 * compute just the sum and store the group key to summation, count 
	 * @param balance
	 */
	private void computeSumAmountInBase(FxAccountBalance balance) {
		GroupKey key = new GroupKey(balance.city, balance.country, balance.creditRating);
		BigDecimal convertedAmount =  convertor.convert(balance.issueAmount, outputCurrency, balance.issueCurrency);
		if(results.containsKey(key)) {
			GroupValue value =  results.get(key);
			value.update(convertedAmount);
		}else {
			GroupValue value = new GroupValue(convertedAmount);
			results.put(key, value);
		}
		
		
	}

	private class FxAccountBalance {

		private int companyCode = -1;

		private int accountId = -1;
		private String city = null;
		private String country = null;
		private String creditRating = null;
		private String issueCurrency = null;
		private BigDecimal issueAmount = null;

	}

}
