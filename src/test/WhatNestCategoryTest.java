import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

class WhatNestCategoryTest {
    @Nested
    class ResetBudgetSpend{

        /*
         * Test that it sets Spend in a category to zero
         * Written by: Berk Demir 28/03/2019
         * Approved by: Panagiotis Petridis
         */
        @Test
        void checkResetBudget(){
            WhatNestCategory cat = new WhatNestCategory();
            BigDecimal zero = new BigDecimal("0");
            cat.resetBudgetSpend();
            assertEquals(0, cat.CategoryBudget().compareTo(zero));
        }
    }
}