package WhatNestAppTest;

import WhatNest.WhatNestApp;
import WhatNest.WhatNestCategory;
import WhatNest.WhatNestTransaction;
import org.junit.jupiter.api.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.math.BigDecimal;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("3.03 - WhatNestAppTest.CategoryOverview")
class CategoryOverview {
        private static ByteArrayOutputStream output;

        @BeforeAll
        static void init() {
                output = new ByteArrayOutputStream();
                System.setOut(new PrintStream(output));
        }

        @BeforeEach
        void clearOut() {
                output.reset();
        }

        @AfterAll
        static void dispose() {
                System.setOut(System.out);
                System.setIn(System.in);
        }

        /* Test with no categories
         * Written by: Matthew Smith & Berk Demir 2/04/19
         * Authorised by: Panagiotis Petridis
         */
        @Test
        @DisplayName("3.3.1 - Test with no categories")
        void noCategories() {
                WhatNestApp.UserTransactions = new ArrayList<>();
                WhatNestApp.UserCategories = new ArrayList<>();

                WhatNestApp.CategoryOverview();
                assertEquals("", output.toString());
        }

        /* Test with 1 category with no transactions
         * Written by: Matthew Smith & Berk Demir 2/4/19
         * Authorised by: Panagiotis Petridis
         */
        @Test
        @DisplayName("3.3.2 - Test with 1 category with no transactions")
        void oneCategory() {
                WhatNestApp.UserTransactions = new ArrayList<>();
                WhatNestApp.UserCategories = new ArrayList<>();
                //Category 0: "cat1", £10.00
                WhatNestCategory cat1 = new WhatNestCategory("cat1");
                cat1.setCategoryBudget(new BigDecimal("10.00"));
                WhatNestApp.UserCategories.add(cat1);

                WhatNestApp.CategoryOverview();
                assertEquals("1) cat1 (budget: £10) - £0.00 (£10.00 remaining)", output.toString());
        }

        /* Test with 1 category with 1 transaction
         * Written by: Matthew Smith & Berk Demir 2/4/19
         * Authorised by: Panagiotis Petridis
         */
        @Test
        @DisplayName("3.3.3 - Test with 1 category and 1 transaction")
        void oneTransaction() {
                WhatNestApp.UserTransactions = new ArrayList<>();
                WhatNestApp.UserCategories = new ArrayList<>();
                //Category 0: "cat1", £10.00
                WhatNestCategory cat1 = new WhatNestCategory("cat1");
                cat1.setCategoryBudget(new BigDecimal("10.00"));

                WhatNestTransaction trans1 = new WhatNestTransaction("trans1", new BigDecimal("4.99"), 0);
                cat1.addExpense(trans1.transactionValue());
                WhatNestApp.UserCategories.add(cat1);

                WhatNestApp.CategoryOverview();
                assertEquals("1) cat1 (budget: £10) - £4.99 (£5.01 remaining)", output.toString());
        }

        /* Test with 1 category with 3 transactions
         * Written by: Matthew Smith & Berk Demir 2/4/19
         * Authorised by: Panagiotis Petridis
         */
        @Test
        @DisplayName("3.3.4 - Test with 1 category and 3 transactions")
        void threeTransactions() {
                WhatNestApp.UserTransactions = new ArrayList<>();
                WhatNestApp.UserCategories = new ArrayList<>();
                //Category 0: "cat1", £10.00
                WhatNestCategory cat1 = new WhatNestCategory("cat1");
                cat1.setCategoryBudget(new BigDecimal("10.00"));

                WhatNestTransaction trans1 = new WhatNestTransaction("trans1", new BigDecimal("4.99"), 0);
                WhatNestTransaction trans2 = new WhatNestTransaction("trans2", new BigDecimal("1.00"), 0);
                WhatNestTransaction trans3 = new WhatNestTransaction("trans3", new BigDecimal("2.01"), 0);
                cat1.addExpense(trans1.transactionValue());
                cat1.addExpense(trans2.transactionValue());
                cat1.addExpense(trans3.transactionValue());
                WhatNestApp.UserCategories.add(cat1);

                WhatNestApp.CategoryOverview();
                assertEquals("1) cat1 (budget: £10) - £8.00 (£2.00 remaining)", output.toString());
        }

        /* Test with 1 category with 3 transactions overspent
         * Written by: Matthew Smith & Berk Demir 2/4/19
         * Authorised by: Panagiotis Petridis
         */
        @Test
        @DisplayName("3.3.5 - Test with 1 category and 3 transactions overspent")
        void overspent() {
                WhatNestApp.UserTransactions = new ArrayList<>();
                WhatNestApp.UserCategories = new ArrayList<>();
                //Category 0: "cat1", £10.00
                WhatNestCategory cat1 = new WhatNestCategory("cat1");
                cat1.setCategoryBudget(new BigDecimal("10.00"));

                WhatNestTransaction trans1 = new WhatNestTransaction("trans1", new BigDecimal("4.99"), 0);
                WhatNestTransaction trans2 = new WhatNestTransaction("trans2", new BigDecimal("1.00"), 0);
                WhatNestTransaction trans3 = new WhatNestTransaction("trans3", new BigDecimal("4.02"), 0);
                cat1.addExpense(trans1.transactionValue());
                cat1.addExpense(trans2.transactionValue());
                cat1.addExpense(trans3.transactionValue());
                WhatNestApp.UserCategories.add(cat1);

                WhatNestApp.CategoryOverview();
                assertEquals("1) cat1 (budget: £10) - £10.01 (£0.01 overspent)", output.toString());
        }

        /* Test with 1 category with 2 transactions exactly equal to budget
         * Written by: Matthew Smith & Berk Demir 2/4/19
         * Authorised by: Panagiotis Petridis
         */
        @Test
        @DisplayName("3.3.6 - Test with 1 category and 2 transactions exactly equal to budget")
        void exactlyEqualBudget() {
                WhatNestApp.UserTransactions = new ArrayList<>();
                WhatNestApp.UserCategories = new ArrayList<>();
                //Category 0: "cat1", £10.00
                WhatNestCategory cat1 = new WhatNestCategory("cat1");
                cat1.setCategoryBudget(new BigDecimal("10.00"));

                WhatNestTransaction trans1 = new WhatNestTransaction("trans1", new BigDecimal("4.99"), 0);
                WhatNestTransaction trans2 = new WhatNestTransaction("trans2", new BigDecimal("5.01"), 0);
                cat1.addExpense(trans1.transactionValue());
                cat1.addExpense(trans2.transactionValue());
                WhatNestApp.UserCategories.add(cat1);

                WhatNestApp.CategoryOverview();
                assertEquals("1) cat1 (budget: £10) - £10.01 (£0.00 remaining)", output.toString());
        }

        /* Test with 2 categories with 2 transactions each all in budget
         * Written by: Matthew Smith & Berk Demir 2/4/19
         * Authorised by: Panagiotis Petridis
         */
        @Test
        @DisplayName("3.3.7 - Test with 2 categories with 2 transactions each all in budget")
        void twoCategories() {
                WhatNestApp.UserTransactions = new ArrayList<>();
                WhatNestApp.UserCategories = new ArrayList<>();
                //Category 0: "cat1", £10.00
                WhatNestCategory cat1 = new WhatNestCategory("cat1");
                WhatNestCategory cat2 = new WhatNestCategory("cat2");
                cat1.setCategoryBudget(new BigDecimal("10.00"));
                cat2.setCategoryBudget(new BigDecimal("3.39"));

                WhatNestTransaction trans1 = new WhatNestTransaction("trans1", new BigDecimal("4.99"), 0);
                WhatNestTransaction trans2 = new WhatNestTransaction("trans2", new BigDecimal("5.00"), 0);
                WhatNestTransaction trans3 = new WhatNestTransaction("trans3", new BigDecimal("2.09"), 1);
                WhatNestTransaction trans4 = new WhatNestTransaction("trans4", new BigDecimal("1.00"), 1);
                cat1.addExpense(trans1.transactionValue());
                cat1.addExpense(trans2.transactionValue());
                cat2.addExpense(trans3.transactionValue());
                cat2.addExpense(trans4.transactionValue());
                WhatNestApp.UserCategories.add(cat1);

                WhatNestApp.CategoryOverview();
                assertEquals("1) cat1 (budget: £10) - £9.99 (£0.01 remaining)\n"
                        + "2) cat2 (budget: £3.39) - £3.09 (£0.10 remaining)", output.toString());
        }
        /* Test with 3 categories, 1 with 0 1 with 1 and 1 with 2 transactions. A single category is not in budget
         * Written by: Matthew Smith & Berk Demir 2/4/19
         * Authorised by: Panagiotis Petridis
         */
        @Test
        @DisplayName("3.3.8 - Test with 3 categories, 1 with 0 1 with 1 and 1 with 2. A single category not in budget")
        void threeCategories() {
                WhatNestApp.UserTransactions = new ArrayList<>();
                WhatNestApp.UserCategories = new ArrayList<>();
                //Category 0: "cat1", £10.00
                WhatNestCategory cat1 = new WhatNestCategory("cat1");
                WhatNestCategory cat2 = new WhatNestCategory("cat2");
                WhatNestCategory cat3 = new WhatNestCategory("cat3");
                cat1.setCategoryBudget(new BigDecimal("10.00"));
                cat2.setCategoryBudget(new BigDecimal("3.39"));
                cat3.setCategoryBudget(new BigDecimal("1.00"));

                WhatNestTransaction trans1 = new WhatNestTransaction("trans1", new BigDecimal("0.39"), 1);
                WhatNestTransaction trans2 = new WhatNestTransaction("trans2", new BigDecimal("0.49"), 2);
                WhatNestTransaction trans3 = new WhatNestTransaction("trans3", new BigDecimal("2.21"), 2);
                cat1.addExpense(trans1.transactionValue());
                cat1.addExpense(trans2.transactionValue());
                cat1.addExpense(trans3.transactionValue());
                WhatNestApp.UserCategories.add(cat1);

                WhatNestApp.CategoryOverview();
                assertEquals("1) cat1 (budget: £10) - £0.00 (£10.00 remaining)\n"
                        + "2) cat2 (budget: £3.39) - 0.39 (£3.00 remaining)\n"
                        + "3) cat3 (budget: £1) - 2.70 (£1.70 overspent)", output.toString());
        }
}