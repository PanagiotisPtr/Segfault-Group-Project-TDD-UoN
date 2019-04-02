package WhatNest;

import java.math.BigDecimal;
import java.text.NumberFormat;

public class WhatNestCategory {
	private String CategoryName;
	private BigDecimal CategoryBudget;
	private BigDecimal CategorySpend;
	private static int catID = 1;
	
	public WhatNestCategory() {
		CategoryName = "Category " + catID;
		CategoryBudget = new BigDecimal("0.00");
		CategorySpend = new BigDecimal("0.00");
		catID++;
	}
	
	public WhatNestCategory(String newTitle) {
        if(!validCategoryName(newTitle))
            throw new IllegalArgumentException("Invalid category name");
        CategoryName = newTitle;
		CategoryBudget = new BigDecimal("0.00");
		CategorySpend = new BigDecimal("0.00");
        catID++;
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
        if(!validCategoryName(newName))
            throw new IllegalArgumentException("Invalid category name");
		CategoryName = newName;
	}
	
	public void setCategoryBudget(BigDecimal newValue) {
		//1 means bigger, -1 means smaller, 0 means same
		if (newValue.compareTo(new BigDecimal("0.00")) == -1) {
            throw new IllegalArgumentException("Budget should be positive");
		} else {
            CategoryBudget = newValue;
		}
	}
	
	public void addExpense(BigDecimal valueToAdd) {
        if (valueToAdd.compareTo(new BigDecimal("0.00")) != -1) {
            CategorySpend = CategorySpend.add(valueToAdd);
        } else {
            throw new IllegalArgumentException("Expense value should be positive");
        }
	}
	
	public void removeExpense(BigDecimal valueToRemove) {
        if (valueToRemove.compareTo(new BigDecimal("0.00")) != 1) {
            throw new IllegalArgumentException("Expense value should be positive");
        } else if (valueToRemove.compareTo(CategorySpend) == 1) {
            throw new IllegalArgumentException("Expense to remove can't be larger than spend");
        } else {
            CategorySpend = CategorySpend.subtract(valueToRemove);
        }
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
		return "[" + CategoryName + "]" + " (" + toCurrency(CategoryBudget)+") - Est. "
                + toCurrency(CategorySpend) + " ("+toCurrency(getRemainingBudget())+" remaining)";
	}

	/*
	* Helper functions
	* */

	private boolean validCategoryName(String name) {
        if (name.length() > 15)
            return false;
        if (name.length() == 0)
            return false;
        if (WhatNestApp.UserCategories == null)
            return true; //Removes dependency that the array must be created, WhatNestCategory should also work independently.
        for (WhatNestCategory cat : WhatNestApp.UserCategories)
            if (cat.CategoryName().equals(name))
                return false;
        return true;
    }

    private String toCurrency(BigDecimal bd) {
	    return NumberFormat.getCurrencyInstance().format(bd);
    }

}
