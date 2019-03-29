import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class WhatNestCategoryTest {
    @Nested
    class removeExpense{

        /*
         * Checks that valid inputs give correct output
         * Written by: Tara Dilley 28/03/2019
         * Approved by: Panagiotis Petridis
         */
        @Test
        void validValuesCheck() {
            WhatNestCategory cat = new WhatNestCategory("Example");
            BigDecimal num1 = new BigDecimal("100.00");
            BigDecimal num2 = new BigDecimal("1.3458934895");

            cat.addExpense(num1);
            cat.removeExpense(num2);

            BigDecimal result = num1.subtract(num2);

            assertEquals(0, cat.CategorySpend().compareTo(result));
        }

        /*
         * Checks 0 is not subtracted
         * Written by: Tara Dilley 28/03/2019
         * Approved by: Panagiotis Petridis
         */
        @Test
        void noZero() {
            WhatNestCategory cat = new WhatNestCategory("Example");
            assertThrows(Exception.class, () -> {
                cat.removeExpense(new BigDecimal("0"));
            });
        }

        /*
         * Checks that negative numbers are not accepted
         * Written by: Tara Dilley 28/03/2019
         * Approved by: Panagiotis Petridis
         */
        @Test
        void noNegative() {
            WhatNestCategory cat = new WhatNestCategory("Example");
            assertThrows(Exception.class, () -> {
                cat.removeExpense(new BigDecimal("-10000.12"));
            });
        }

        /*
         * Checks that large positive numbers are accepted
         * Written by: Tara Dilley 28/03/2019
         * Approved by: Panagiotis Petridis
         */
        @Test
        void largePositive() {
            WhatNestCategory cat = new WhatNestCategory("Example");
            BigDecimal num1 = new BigDecimal("100000000000");
            BigDecimal num2 = new BigDecimal("99999999999");

            cat.addExpense(num1);
            cat.removeExpense(num2);

            assertEquals(0, cat.CategorySpend().compareTo(num1.subtract(num2)));
        }

        /*
         * Test with expense larger than spend
         * Written by: Tara Dilley 28/03/2019
         * Approved by: Panagiotis Petridis
         */
        @Test
        void expenseLargerThanSpend() {
            WhatNestCategory cat = new WhatNestCategory("Example");

            BigDecimal budget = new BigDecimal("400");
            cat.setCategoryBudget(budget);

            BigDecimal spend = new BigDecimal("200");
            cat.addExpense(spend);

            assertThrows(Exception.class, () -> {
                cat.removeExpense(new BigDecimal("400"));
            });
        }
    }

    @Nested
    class getRemainingBudget {
        /*
         * Test that correct remaining budget is found
         * Written by: Tara Dilley 28/03/2019
         * Approved by: Panagiotis Petridis
         */
        @Test
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

    @Nested
    class toStringOverride{

        /*
         * Checks output when values are all 0
         * Written by: Tara Dilley 28/03/2019
         * Approved by: Panagiotis Petridis
         */
        @Test
        void checkZero() {
            WhatNestCategory cat = new WhatNestCategory("Example");

            BigDecimal num = new BigDecimal("0");
            cat.setCategoryBudget(num);
            cat.addExpense(num);

            assertEquals("[Example] (£0.00) - Est. £0.00 (£0.00 remaining)", cat.toString());
        }

        /*
         * Checks a valid non-zero test case
         * Written by: Tara Dilley 28/03/2019
         * Approved by: Panagiotis Petridis
         */
        @Test
        void checkValidCase() {
            WhatNestCategory cat = new WhatNestCategory("Example");

            BigDecimal budget = new BigDecimal("400");
            cat.setCategoryBudget(budget);

            BigDecimal spend = new BigDecimal("200");
            cat.addExpense(spend);

            assertEquals("[Example] (£400.00) - Est. £200.00 (£200.00 remaining)", cat.toString());
        }

        /*
         * Checks that values are correct when user has overspent
         * Written by: Tara Dilley 28/03/2019
         * Approved by: Panagiotis Petridis
         */
        @Test
        void checkOverspentCase() {
            WhatNestCategory cat = new WhatNestCategory("Example");

            BigDecimal budget = new BigDecimal("400");
            cat.setCategoryBudget(budget);

            BigDecimal spend = new BigDecimal("500");
            cat.addExpense(spend);

            assertEquals("[Example] (£400.00) - Est. £500.00 (£100.00 overspent)", cat.toString());
        }


    }


}