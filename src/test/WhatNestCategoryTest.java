import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class WhatNestCategoryTest {
    @Nested
    class CategoryName{
        /* Create Category object with name "Example" and make sure it returns 
         * the correct category name
         * Written by: Lars Lunde
         * Date: 25/03/2019
         * Authorised by: Matthew Smith
         */
        @Test
        void testCategoryName(){
            WhatNestCategory cat = new WhatNestCategory("Example");
            assertEquals("Example", cat.CategoryName());
        }
    }

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

    @Nested
    class CategorySpend {
        /*
         * Create Category object with name "Example" and spend to 300 and make
         * sure that getCategorySpend returns 300
         * Written by: Lars Lunde 28/03/2019
         * Approved by: Panagiotis Petridis
         */
        @Test
        void testCategorySpend() {
            WhatNestCategory cat = new WhatNestCategory();
            BigDecimal tmp = new BigDecimal("300.0");
            cat.addExpense(tmp);
            assertEquals(0, tmp.compareTo(cat.CategorySpend()));
        }
    }
}