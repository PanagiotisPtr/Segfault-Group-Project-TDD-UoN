package WhatNest;

import java.math.BigDecimal;

public class WhatNestCategory {
	private String CategoryName;
	private BigDecimal CategoryBudget;
	private BigDecimal CategorySpend;
	
	
	public WhatNestCategory() {
		CategoryName = "New Category";
		CategoryBudget = new BigDecimal("0.00");
		CategorySpend = new BigDecimal("0.00");
	}
	
	public WhatNestCategory(String newTitle) {
		CategoryName = newTitle;
		CategoryBudget = new BigDecimal("0.00");
		CategorySpend = new BigDecimal("0.00");
	}
	
	public String CategoryName() {
		return CategoryName;
	}
	
	public BigDecimal CategoryBudget() {
		return CategoryBudget;
	}
	
	public BigDecimal CategorySpend() {
		return CategorySpend;
	}
	
	public void setCategoryName(String newName) throws IllegalArgumentException {
        if (newName.length() > 15) {
            throw new IllegalArgumentException("Name should be 15 characters or less");
        }
        if (newName.length() == 0) {
            throw new IllegalArgumentException("Name should not be empty");
        }
		CategoryName = newName;
	}
	
	public void setCategoryBudget(BigDecimal newValue) {
		//1 means bigger, -1 means smaller, 0 means same
		if (newValue.compareTo(new BigDecimal("0.00")) == 1) {
			CategoryBudget = newValue;
		}
	}
	
	public void addExpense(BigDecimal valueToAdd) {
		CategorySpend = CategorySpend.add(valueToAdd);
	}
	
	public void removeExpense(BigDecimal valueToRemove) {
		CategorySpend = CategorySpend.subtract(valueToRemove);
	}
	
	public void resetBudgetSpend() {
		CategorySpend = new BigDecimal("0.00");
	}
	
	
	public BigDecimal getRemainingBudget() {
		BigDecimal remainingBudget = CategoryBudget.subtract(CategorySpend);
		return remainingBudget;
	}
	
	@Override
	public String toString() {
		return CategoryName + "(£"+CategoryBudget.toPlainString()+") - Est. £"+CategorySpend.toPlainString()+" (£"+getRemainingBudget().toPlainString()+" remaining)";
	}
	
}
