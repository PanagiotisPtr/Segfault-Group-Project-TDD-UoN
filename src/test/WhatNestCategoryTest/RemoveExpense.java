package WhatNestCategoryTest;

import WhatNest.WhatNestCategory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@DisplayName("2.09 - WhatNestCategoryTest.RemoveExpense")
class RemoveExpense {
    /*
     * Checks that valid inputs give correct output
     * Written by: Tara Dilley 28/03/2019
     * Approved by: Panagiotis Petridis
     */
    @Test
    @DisplayName("2.9.1 - Checks that valid inputs give correct output")
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
    @DisplayName("2.9.2 - Checks 0 is not subtracted")
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
    @DisplayName("2.9.3 - Checks that negative numbers are not accepted")
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
    @DisplayName("2.9.4 - Checks that large positive numbers are accepted")
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
    @DisplayName("2.9.5 - Test with expense larger than spend")
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
