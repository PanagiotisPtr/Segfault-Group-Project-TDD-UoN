package WhatNestCategoryTest;

import WhatNest.WhatNestCategory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("2.11 - WhatNestCategoryTest.getRemainingBudget")
class getRemainingBudget {
    /*
     * Test that correct remaining budget is found
     * Written by: Tara Dilley 28/03/2019
     * Approved by: Panagiotis Petridis
     */
    @Test
    @DisplayName("2.11.1 - Test that correct remaining budget is found")
    void getRemainingBudgetTest() {
        WhatNestCategory cat = new WhatNestCategory("Example");
        BigDecimal budget = new BigDecimal("400");
        cat.setCategoryBudget(budget);
        BigDecimal spend = new BigDecimal("200");
        cat.addExpense(spend);
        BigDecimal result = new BigDecimal("200");
        assertEquals(0, cat.getRemainingBudget().compareTo(result));
    }
}
