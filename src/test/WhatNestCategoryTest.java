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
         * Approved by:
         */
        @Test
        void spendAndBudget() {
            WhatNestCategory cat = new WhatNestCategory();
            assertEquals(new BigDecimal("0.00"), cat.CategorySpend());
            assertEquals(new BigDecimal("0.00"), cat.CategoryBudget());
        }

        /*
         * Check that each name is unique by creating multiple classes (1000+)
         * and make sure they all have unique names
         * Written by: Matthew Smith 28/03/2019
         * Approved by:
         */
        @Test
        void uniqueName() {
            HashSet<String> usedNames = new HashSet<>();

            for(int i = 0; i < 1000; i++) {
                WhatNestCategory c = new WhatNestCategory();
                if(usedNames.contains(c.CategoryName()))
                    fail();
                usedNames.add(c.CategoryName());
            }
        }
    }
}