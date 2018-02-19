package com.ubs.data;

import java.math.BigDecimal;

public class GroupValue {

	
	private BigDecimal sumIssueAmount = null;
	
	private int groupCount = 0;
	
	public GroupValue(BigDecimal sumIssueAmount) {
		super();
		this.sumIssueAmount = sumIssueAmount;
	}

	
	public void update(BigDecimal issueAmount) {
		this.sumIssueAmount = sumIssueAmount.add(issueAmount);
		groupCount++;
	}
	
	public BigDecimal computeAverage() {
		return this.sumIssueAmount.divide(new BigDecimal(groupCount));
	}
}
