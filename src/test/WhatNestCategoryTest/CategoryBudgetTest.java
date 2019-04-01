package WhatNestCategoryTest;

import WhatNest.WhatNestCategory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("2.02 - WhatNestCategoryTest.CategoryBudgetTest")
class CategoryBudgetTest {
    /*
     * Create Category object with name "Example" and budget to 12 and make
     * sure that getCategoryBudget returns 12
     * Written by: Lars Lunde 28/03/2019
     * Approved by: Panagiotis Petridis
     */
     @Test
     @DisplayName("2.2.1 - sure that getCategoryBudget returns 12")
     void testCategoryBudget() {
        WhatNestCategory cat = new WhatNestCategory("Example");
        BigDecimal tmp = new BigDecimal("12.0");
        cat.setCategoryBudget(tmp);
        assertEquals(0, tmp.compareTo(cat.CategoryBudget()));
     }
}
