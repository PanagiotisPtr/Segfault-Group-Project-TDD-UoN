import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class WhatNestCategoryTest {
    @Nested
    class SetCategoryName {
        /*
         * Make sure that the name changes when you call function with a string
         * Written by: Lars Lunde 28/03/2019
         * Approved by: Panagiotis Petridis
         */
        @Test
        void baseCase() {
            WhatNestCategory cat = new WhatNestCategory("Example");
            cat.setCategoryName("AnotherName");
            assertEquals("AnotherName", cat.CategoryName());
        }

        /*
         * Check that it handles long names
         * Written by: Lars Lunde 28/03/2019
         * Approved by: Panagiotis Petridis
         */
        @Test
        void longName() {
            WhatNestCategory cat = new WhatNestCategory("Example");
            assertThrows(Exception.class, () -> {
                cat.setCategoryName("AVeryVeryLongLongName");        
            });
        }

        /*
         * Check that it handles empty names
         * Written by: Lars Lunde 28/03/2019
         * Approved by: Panagiotis Petridis
         */
        @Test
        void emptyName() {
            WhatNestCategory cat = new WhatNestCategory("Example");
            assertThrows(Exception.class, () -> {
                cat.setCategoryName("");
            });
        }

        /*
         * Create 2 classes with same name make sure it gives error
         * Written by: Lars Lunde 28/03/2019
         * Approved by: Panagiotis Petridis
         */
        @Test
        void duplicateCategory() {
            WhatNestCategory cat = new WhatNestCategory("Example");
            assertThrows(Exception.class, () -> {
                WhatNestCategory dog = new WhatNestCategory("Example");
            });
        }

        /*
         * Make sure that class has spend and budget to 0 and not an arbitrary
         * value
         * Written by: Lars Lunde 28/03/2019
         * Approved by: Panagiotis Petridis
         */
        @Test
        void testDefaults() {
            WhatNestCategory cat = new WhatNestCategory("Example");
            BigDecimal tmp = new BigDecimal("0.00");
            assertEquals(0, cat.CategorySpend().compareTo(tmp));
            assertEquals(0, cat.CategoryBudget().compareTo(tmp));
        }

        /*
         * Check Unicode characters
         * Using Constructor
         * Written by: Lars Lunde 28/03/2019
         * Approved by: Panagiotis Petridis
         */
        @Test
        void testUnicodeName() {
            WhatNestCategory cat = new WhatNestCategory("Example");
            cat.setCategoryName("σφαλμα");
            assertEquals("σφαλμα", cat.CategoryName());
        }
    }
}