import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class WhatNestCategoryTest {
    @Nested
    class CategoryBudgetTest {
        /*
         * Create Category object with name "Example" and budget to 12 and make
         * sure that getCategoryBudget returns 12
         * Written by: Lars Lunde 28/03/2019
         * Approved by: Panagiotis Petridis
         */
        @Test
        void testCategoryBudget() {
            WhatNestCategory cat = new WhatNestCategory("Example");
            BigDecimal tmp = new BigDecimal("12.0");
            cat.setCategoryBudget(tmp);
            assertEquals(0, tmp.compareTo(cat.CategoryBudget()));
        }
    }
}