package WhatNestCategoryTest;

import WhatNest.WhatNestCategory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("2.03 - WhatNestCategoryTest.CategorySpend")
class CategorySpend {
    /*
     * Create Category object with name "Example" and spend to 300 and make
     * sure that getCategorySpend returns 300
     * Written by: Lars Lunde 28/03/2019
     * Approved by: Panagiotis Petridis
     */
    @Test
    @DisplayName("2.3.1 - sure that getCategorySpend returns 300")
    void testCategorySpend() {
        WhatNestCategory cat = new WhatNestCategory();
        BigDecimal tmp = new BigDecimal("300.0");
        cat.addExpense(tmp);
        assertEquals(0, tmp.compareTo(cat.CategorySpend()));
    }
}

