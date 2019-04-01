package WhatNestCategoryTest;

import WhatNest.WhatNestCategory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("2.10 - WhatNestCategoryTest.ResetBudgetSpend")
class ResetBudgetSpend {
    /*
     * Test that it sets Spend in a category to zero
     * Written by: Berk Demir 28/03/2019
     * Approved by: Panagiotis Petridis
     */
    @Test
    @DisplayName("2.10.1 - Test that it sets Spend in a category to zero")
    void checkResetBudget() {
        WhatNestCategory cat = new WhatNestCategory();
        BigDecimal zero = new BigDecimal("0");
        cat.resetBudgetSpend();
        assertEquals(0, cat.CategoryBudget().compareTo(zero));
    }
}
