import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class WhatNestCategoryTest {
    @Nested
    class addExpenseTest {
        /*
         * Test that it accepts BigDecimal type
         * Written by: Lars Lunde 28/03/2019
         * Approved by: Panagiotis Petridis
         */
        @Test
        void baseBigDecimal() {
            WhatNestCategory cat = new WhatNestCategory("Example");
            BigDecimal bgd = new BigDecimal("100.00");
            cat.setCategoryBudget(bgd);
            BigDecimal tmp = new BigDecimal("1.34589349");
            cat.addExpense(tmp);
            BigDecimal result = bgd.subtract(tmp);
            assertEquals(0, cat.getRemainingBudget().compareTo(result));
        }

        /*
         * Test with integer, set default budget to 100
         * Written by: Lars Lunde 28/03/2019
         * Approved by: Panagiotis Petridis
         */
        @Test
        void testInt() {
            WhatNestCategory cat = new WhatNestCategory("Example");
            BigDecimal bgd = new BigDecimal("100.00");
            cat.setCategoryBudget(bgd);
            BigDecimal tmp = new BigDecimal("1");
            cat.addExpense(tmp);
            BigDecimal result = bgd.subtract(tmp);
            assertEquals(0, cat.getRemainingBudget().compareTo(result));
        }

        /*
         * Test with negative numbers, set default budget to 100
         * Written by: Lars Lunde 28/03/2019
         * Approved by: Panagiotis Petridis
         */
        @Test
        void negativeNumb() {
            WhatNestCategory cat = new WhatNestCategory("Example");
            BigDecimal bgd = new BigDecimal("100.00");
            cat.setCategoryBudget(bgd);
            BigDecimal neg = new BigDecimal("-10.12");
            assertThrows(Exception.class, () -> {
                cat.addExpense(neg);
            });
        }

        /*
         * Test with large positive number, set default budget to
         * 10000000000000.00
         * Written by: Lars Lunde 28/03/2019
         * Approved by: Panagiotis Petridis
         */
        @Test
        void largeNum() {
            WhatNestCategory cat = new WhatNestCategory("Example");
            BigDecimal bgd = new BigDecimal("10000000000000.00");
            cat.setCategoryBudget(bgd);
            BigDecimal big = new BigDecimal("99999999999");
            cat.addExpense(big);
            BigDecimal result = bgd.subtract(big);
            assertEquals(0, cat.getRemainingBudget().compareTo(result));
        }

        /*
         * Test with expense larger than budget. Category created with name
         * "Example", Budget 400 and spend 200, when given an expense bigger
         * than the budget (600) sets the budget to negative number.
         * Written by: Lars Lunde 28/03/2019
         * Approved by: Panagiotis Petridis
         */
        @Test
        void overBudget() {
            WhatNestCategory cat = new WhatNestCategory("Example");
            BigDecimal bgd = new BigDecimal("200.00");
            cat.setCategoryBudget(bgd);
            BigDecimal big = new BigDecimal("400.00");
            cat.addExpense(big);
            BigDecimal result = bgd.subtract(big);
            assertEquals(0, cat.getRemainingBudget().compareTo(result));
        }
    }
}