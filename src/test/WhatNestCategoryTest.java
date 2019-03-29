import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.*;

class WhatNestCategoryTest {
    @Nested
    class DefaultConstructor {
        /*
         * Check that both spend and budget are set to 0
         * Written by: Matthew Smith 28/03/2019
         * Approved by: Panagiotis Petridis
         */
        @Test
        void spendAndBudget() {
            WhatNestCategory cat = new WhatNestCategory();
            BigDecimal zero = new BigDecimal("0.00");
            assertEquals(0, cat.CategorySpend().compareTo(zero));
            assertEquals(0, cat.CategoryBudget().compareTo(zero));
        }

        /*
         * Check that each name is unique by creating multiple classes (1000+)
         * and make sure they all have unique names
         * Written by: Matthew Smith 28/03/2019
         * Approved by: Panagiotis Petridis
         */
        @Test
        void uniqueName() {
            HashSet<String> usedNames = new HashSet<>();

            for(int i = 0; i < 1000; i++) {
                WhatNestCategory c = new WhatNestCategory();
                assertFalse(usedNames.contains(c.CategoryName()));
                usedNames.add(c.CategoryName());
            }
        }
    }
}