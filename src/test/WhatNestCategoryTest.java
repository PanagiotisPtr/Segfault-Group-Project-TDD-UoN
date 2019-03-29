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

    @Nested
    class MainConstructor{

        /*
         * Check that it meets specification
         * Written by: Berk Demir 28/03/2019
         * Approved by: Panagiotis Petridis
         */
        @Test
        void checkCreate() {
            WhatNestCategory cat = new WhatNestCategory("Example");
            assertEquals("Example", cat.CategoryName());
        }

        /*
         * Create 2 classes with same name make sure it gives error
         * Written by: Berk Demir 28/03/2019
         * Approved by: Panagiotis Petridis
         */
        @Test
        void checkDuplicate() {
            WhatNestCategory dup = new WhatNestCategory("Example");
            assertThrows(Exception.class, ()->{
                WhatNestCategory dup2 = new WhatNestCategory("Example");
            });
        }

        /*
         * Make sure that class has spend and budget to 0 and not an arbitrary value
         * Written by: Berk Demir 28/03/2019
         * Approved by: Panagiotis Petridis
         */
        @Test
        void checkZeros() {
            WhatNestCategory def = new WhatNestCategory("Example");
            BigDecimal zero = new BigDecimal(0);
            assertEquals(0, def.CategorySpend().compareTo(zero));
            assertEquals(0, def.CategoryBudget().compareTo(zero));
        }
        /*
         * Check Unicode characters
         * Written by: Berk Demir 28/03/2019
         * Approved by: Panagiotis Petridis
         */
        @Test
        void checkUnicode() {
            WhatNestCategory uni = new WhatNestCategory("σφαλμα");
            assertEquals("σφαλμα", uni.CategoryName());
        }
        /*
         * Check that default constructor handles long names
         * Written by: Berk Demir 28/03/2019
         * Approved by: Panagiotis Petridis
         */
        @Test
        void checkLongName() {
            assertThrows(Exception.class, ()->{
                WhatNestCategory lng = new WhatNestCategory("AVeryVeryVeryLongLongLongName");
            });
        }

        /*
         * Check that it handles empty names
         * Written by: Berk Demir 28/03/2019
         * Approved by: Panagiotis Petridis
         */
        @Test
        void checkBlank() {
            assertThrows(Exception.class, ()->{
                WhatNestCategory blank = new WhatNestCategory("");
            });
        }
    }

    @Nested
    class addExpenseTest {
        /*
         * Test that it accepts BigDecimal type
         * Written by: Lars Lunde 28/03/2019
         * Approved by: Panagiotis Petridis
         */
        @Test
        void baseBigDecimal() {
            WhatNestCategory cat = new WhatNestCategory("Example");
            BigDecimal bgd = new BigDecimal("100.00");
            cat.setCategoryBudget(bgd);
            BigDecimal tmp = new BigDecimal("1.34589349");
            cat.addExpense(tmp);
            BigDecimal result = bgd.subtract(tmp);
            assertEquals(0, cat.getRemainingBudget().compareTo(result));
        }

        /*
         * Test with integer, set default budget to 100
         * Written by: Lars Lunde 28/03/2019
         * Approved by: Panagiotis Petridis
         */
        @Test
        void testInt() {
            WhatNestCategory cat = new WhatNestCategory("Example");
            BigDecimal bgd = new BigDecimal("100.00");
            cat.setCategoryBudget(bgd);
            BigDecimal tmp = new BigDecimal("1");
            cat.addExpense(tmp);
            BigDecimal result = bgd.subtract(tmp);
            assertEquals(0, cat.getRemainingBudget().compareTo(result));
        }

        /*
         * Test with negative numbers, set default budget to 100
         * Written by: Lars Lunde 28/03/2019
         * Approved by: Panagiotis Petridis
         */
        @Test
        void negativeNumb() {
            WhatNestCategory cat = new WhatNestCategory("Example");
            BigDecimal bgd = new BigDecimal("100.00");
            cat.setCategoryBudget(bgd);
            BigDecimal neg = new BigDecimal("-10.12");
            assertThrows(Exception.class, () -> {
                cat.addExpense(neg);
            });
        }

        /*
         * Test with large positive number, set default budget to
         * 10000000000000.00
         * Written by: Lars Lunde 28/03/2019
         * Approved by: Panagiotis Petridis
         */
        @Test
        void largeNum() {
            WhatNestCategory cat = new WhatNestCategory("Example");
            BigDecimal bgd = new BigDecimal("10000000000000.00");
            cat.setCategoryBudget(bgd);
            BigDecimal big = new BigDecimal("99999999999");
            cat.addExpense(big);
            BigDecimal result = bgd.subtract(big);
            assertEquals(0, cat.getRemainingBudget().compareTo(result));
        }

        /*
         * Test with expense larger than budget. Category created with name
         * "Example", Budget 400 and spend 200, when given an expense bigger
         * than the budget (600) sets the budget to negative number.
         * Written by: Lars Lunde 28/03/2019
         * Approved by: Panagiotis Petridis
         */
        @Test
        void overBudget() {
            WhatNestCategory cat = new WhatNestCategory("Example");
            BigDecimal bgd = new BigDecimal("200.00");
            cat.setCategoryBudget(bgd);
            BigDecimal big = new BigDecimal("400.00");
            cat.addExpense(big);
            BigDecimal result = bgd.subtract(big);
            assertEquals(0, cat.getRemainingBudget().compareTo(result));
        }
    }

    @Nested
    class removeExpense{

        /*
         * Checks that valid inputs give correct output
         * Written by: Tara Dilley 28/03/2019
         * Approved by: Panagiotis Petridis
         */
        @Test
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

    @Nested
    class ResetBudgetSpend{

        /*
         * Test that it sets Spend in a category to zero
         * Written by: Berk Demir 28/03/2019
         * Approved by: Panagiotis Petridis
         */
        @Test
        void checkResetBudget(){
            WhatNestCategory cat = new WhatNestCategory();
            BigDecimal zero = new BigDecimal("0");
            cat.resetBudgetSpend();
            assertEquals(0, cat.CategoryBudget().compareTo(zero));
        }
    }

    @Nested
    class getRemainingBudget {
        /*
         * Test that correct remaining budget is found
         * Written by: Tara Dilley 28/03/2019
         * Approved by: Panagiotis Petridis
         */
        @Test
        void getRemainingBudgetTest() {
            WhatNestCategory cat = new WhatNestCategory("Example");

            BigDecimal budget = new BigDecimal("400");
            cat.setCategoryBudget(budget);

            BigDecimal spend = new BigDecimal("200");
            cat.addExpense(spend);

            BigDecimal result = new BigDecimal("200");
            assertEquals(0, cat.getRemainingBudget().compareTo(result));
        }
    }

    @Nested
    class toStringOverride{

        /*
         * Checks output when values are all 0
         * Written by: Tara Dilley 28/03/2019
         * Approved by: Panagiotis Petridis
         */
        @Test
        void checkZero() {
            WhatNestCategory cat = new WhatNestCategory("Example");

            BigDecimal num = new BigDecimal("0");
            cat.setCategoryBudget(num);
            cat.addExpense(num);

            assertEquals("[Example] (£0.00) - Est. £0.00 (£0.00 remaining)", cat.toString());
        }

        /*
         * Checks a valid non-zero test case
         * Written by: Tara Dilley 28/03/2019
         * Approved by: Panagiotis Petridis
         */
        @Test
        void checkValidCase() {
            WhatNestCategory cat = new WhatNestCategory("Example");

            BigDecimal budget = new BigDecimal("400");
            cat.setCategoryBudget(budget);

            BigDecimal spend = new BigDecimal("200");
            cat.addExpense(spend);

            assertEquals("[Example] (£400.00) - Est. £200.00 (£200.00 remaining)", cat.toString());
        }

        /*
         * Checks that values are correct when user has overspent
         * Written by: Tara Dilley 28/03/2019
         * Approved by: Panagiotis Petridis
         */
        @Test
        void checkOverspentCase() {
            WhatNestCategory cat = new WhatNestCategory("Example");

            BigDecimal budget = new BigDecimal("400");
            cat.setCategoryBudget(budget);

            BigDecimal spend = new BigDecimal("500");
            cat.addExpense(spend);

            assertEquals("[Example] (£400.00) - Est. £500.00 (£100.00 overspent)", cat.toString());
        }
    }
}
