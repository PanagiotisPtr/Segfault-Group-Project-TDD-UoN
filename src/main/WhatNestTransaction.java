import java.math.BigDecimal;
import java.util.Date;

public class WhatNestTransaction {
	private String transactionName;
	private BigDecimal transactionValue;
	private int transactionCategory;
	private Date transactionTime;
	
	
	public WhatNestTransaction() {
		transactionName = null;
		transactionValue = null;
		transactionCategory = 0;
		transactionTime = null;
	}
	
	public WhatNestTransaction(String tName, BigDecimal tValue, int tCat) {
		transactionName = tName;
		transactionValue = tValue;
		transactionCategory = tCat;
		transactionTime = new Date();
	}
	
	// I ADDED THIS TO RUN THE MAVEN TESTS
	// DO NOT - DO NOT - DO NOT
	// PUT THIS IN PRODUCTION
	public boolean isComplete() {
		return false;
	}
	
	public String transactionName() {
		return transactionName;
	}
	
	public BigDecimal transactionValue() {
		return transactionValue;
	}
	
	public int transactionCategory() {
		return transactionCategory;
	}
	
	public Date transactionTime() {
		return transactionTime;
	}
	
	public void setTransactionName(String tName) {
		if (tName != null) {
			transactionName = tName;
		}
	}
	
	public void setTransactionValue(BigDecimal tValue) {
		
		if (tValue.compareTo(new BigDecimal("0.00")) == 1) {
			//1 means bigger, -1 means smaller, 0 means same
			transactionValue = tValue;
		}
	}
	
	public void setTransactionCategory(int tCat) {
		if (tCat > 0) {
			transactionCategory = tCat;
		}
	}
	
	public void setTransactionTime(Date tTime) {
		if (tTime != null) {
			transactionTime = tTime;
		}
	}
	
	@Override
	public String toString() {
		return transactionName + " - £" + transactionValue.toString();
	}
	
}
