package WhatNestCategoryTest;

import WhatNest.WhatNestCategory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@DisplayName("2.05 - WhatNestCategoryTest.SetCategoryBudget")
class SetCategoryBudget {
    /*
     * Test that it accepts floats
     * Written by: Lars Lunde 28/03/2019
     * Approved by: Panagiotis Petridis
     */
    @Test
    @DisplayName("2.5.1 - Test that it accepts floats")
    void baseCase() {
        WhatNestCategory cat = new WhatNestCategory("Example");
        BigDecimal tmp = new BigDecimal("2500.01");
        cat.setCategoryBudget(tmp);
        assertEquals(0, cat.CategoryBudget().compareTo(tmp));
    }
    /*
     * Test that it does not accept negatives
     * Written by: Lars Lunde 28/03/2019
     * Approved by: Panagiotis Petridis
     */
    @Test
    @DisplayName("2.5.2 - Test that it does not accept negatives")
    void negativeCase() {
        WhatNestCategory cat = new WhatNestCategory("Example");
        BigDecimal tmp = new BigDecimal("-2.5");
        assertThrows(Exception.class, () -> {
            cat.setCategoryBudget(tmp);
        });
    }
    /*
     * Check very large numbers
     * Written by: Lars Lunde 28/03/2019
     * Approved by: Panagiotis Petridis
     */
    @Test
    @DisplayName("2.5.3 - Check very large numbers")
    void largeNumber() {
        WhatNestCategory cat = new WhatNestCategory("Example");
        BigDecimal tmp = new BigDecimal("999999.99999999900");
        cat.setCategoryBudget(tmp);
        assertEquals(0, cat.CategoryBudget().compareTo(tmp));
    }
}
