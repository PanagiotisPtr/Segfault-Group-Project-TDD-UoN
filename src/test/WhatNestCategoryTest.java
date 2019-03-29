import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.HashSet;

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

    @Nested
    class TestSetCategoryBudget {

        /*
         * Test that it accepts floats
         * Written by: Lars Lunde 28/03/2019
         * Approved by: Panagiotis Petridis
         */
        @Test
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
        void largeNumber() {
            WhatNestCategory cat = new WhatNestCategory("Example");
            BigDecimal tmp = new BigDecimal("999999.99999999900");
            cat.setCategoryBudget(tmp);
            assertEquals(0, cat.CategoryBudget().compareTo(tmp));
        }
    }

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
