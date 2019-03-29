import org.junit.jupiter.api.*;

import java.io.*;
import java.math.BigDecimal;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class WhatNestAppTest {
    static ByteArrayOutputStream output;

    @BeforeAll
    static void init() {
        output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));
    }

    @Nested
    public class ListTransactions {

        @BeforeEach
        void clearOut() {
            output.reset();
        }

        /* 3.2.1 - Test with no transaction history
         * Written by: Matthew Smith 25/03/19
         * Authorised by: Panagiotis Petridis
         */
        @Test
        void noTransactions() {
            WhatNestApp.UserTransactions = new ArrayList<>();
            WhatNestApp.UserCategories = new ArrayList<>();

            WhatNestApp.ListTransactions();
            assertEquals("", output.toString());
        }

        /* 3.2.2 - Test with single transaction in history
         * Written by: Matthew Smith 25/03/19
         * Authorised by: Panagiotis Petridis
         */
        @Test
        void singleTransaction() {
            WhatNestApp.UserTransactions = new ArrayList<>();
            WhatNestApp.UserTransactions.add(
                    new WhatNestTransaction("trans1",new BigDecimal("4.39"), 0));
            WhatNestApp.UserCategories = new ArrayList<>();
            WhatNestApp.UserCategories.add(
                    new WhatNestCategory("cat1"));

            WhatNestApp.ListTransactions();
            assertEquals("1) trans1 (cat1) - £4.39\n", output.toString());
        }

        /* 3.2.3 - Test with multiple valid items in transaction history.
         * Written by: Matthew Smith 25/03/19
         * Authorised by: Panagiotis Petridis
         */
        @Test
        void manyTransactions() {
            WhatNestApp.UserTransactions = new ArrayList<>();
            WhatNestApp.UserTransactions.add(
                    new WhatNestTransaction("trans1",new BigDecimal("4.39"), 0));
            WhatNestApp.UserTransactions.add(
                    new WhatNestTransaction("trans2",new BigDecimal("43.21"), 0));
            WhatNestApp.UserTransactions.add(
                    new WhatNestTransaction("trans3",new BigDecimal("2.57"), 1));
            WhatNestApp.UserCategories = new ArrayList<>();
            WhatNestApp.UserCategories.add(new WhatNestCategory("cat1"));
            WhatNestApp.UserCategories.add(new WhatNestCategory("cat3"));

            WhatNestApp.ListTransactions();
            assertEquals("1) trans1 (cat1) - £4.39\n2) trans2 (cat2) - £43.21\n2) trans3 (cat3) - £2.57\n"
                    , output.toString());
        }

        /* 3.2.4 - Test with unicode input
         * Written by: Matthew Smith 25/03/19
         * Authorised by: Panagiotis Petridis
         */
        @Test
        void unicode() {
            WhatNestApp.UserTransactions = new ArrayList<>();
            WhatNestApp.UserTransactions.add(
                    new WhatNestTransaction("Συναλλαγή",new BigDecimal("4.39"), 0));
            WhatNestApp.UserCategories = new ArrayList<>();
            WhatNestApp.UserCategories.add(
                    new WhatNestCategory("κατηγορία"));

            WhatNestApp.ListTransactions();
            assertEquals("1) Συναλλαγή (κατηγορία) - £4.39\n", output.toString());
        }

        /* 3.2.5 - Test with no numbers in decimal place
         * Written by: Matthew Smith 25/03/19
         * Authorised by: Panagiotis Petridis
         */
        @Test
        void noDecimals() {
            WhatNestApp.UserTransactions = new ArrayList<>();
            WhatNestApp.UserTransactions.add(
                    new WhatNestTransaction("trans1",new BigDecimal("4"), 0));
            WhatNestApp.UserCategories = new ArrayList<>();
            WhatNestApp.UserCategories.add(
                    new WhatNestCategory("cat1"));

            WhatNestApp.ListTransactions();
            assertEquals("1) trans1 (cat1) - £4.00\n", output.toString());
        }

        /* 3.2.6 - Test with 1 number in decimal place
         * Written by: Matthew Smith 25/03/19
         * Authorised by: Panagiotis Petridis
         */
        @Test
        void oneDecimal() {
            WhatNestApp.UserTransactions = new ArrayList<>();
            WhatNestApp.UserTransactions.add(
                    new WhatNestTransaction("trans1",new BigDecimal("4.1"), 0));
            WhatNestApp.UserCategories = new ArrayList<>();
            WhatNestApp.UserCategories.add(
                    new WhatNestCategory("cat1"));

            WhatNestApp.ListTransactions();
            assertEquals("1) trans1 (cat1) - £4.10\n", output.toString());
        }

        /* 3.2.7 - Test with out of range category
         * Written by: Matthew Smith 25/03/19
         * Authorised by: Panagiotis Petridis
         */
        @Test
        void badCategory() {
            WhatNestApp.UserTransactions = new ArrayList<>();
            WhatNestApp.UserTransactions.add(
                    new WhatNestTransaction("trans1",new BigDecimal("4.1"), 1));
            WhatNestApp.UserCategories = new ArrayList<>();
            WhatNestApp.UserCategories.add(
                    new WhatNestCategory("cat1"));

            assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
                WhatNestApp.ListTransactions();
            });
        }

        /* 3.2.8 - Test with too many decimal places
         * Written by: Matthew Smith 25/03/19
         * Authorised by: Panagiotis Petridis
         */
        @Test
        void manyDecimals() {
            WhatNestApp.UserTransactions = new ArrayList<>();
            WhatNestApp.UserTransactions.add(
                    new WhatNestTransaction("trans1",new BigDecimal("4.123"), 0));
            WhatNestApp.UserTransactions.add(
                    new WhatNestTransaction("trans2",new BigDecimal("4.127"), 0));
            WhatNestApp.UserCategories = new ArrayList<>();
            WhatNestApp.UserCategories.add(
                    new WhatNestCategory("cat1"));

            WhatNestApp.ListTransactions();
            assertEquals("1) trans1 (cat1) - £4.12\n2) trans2 (cat1) - £4.13\n"
                    , output.toString());
        }

        /* 3.2.9 - Test with large value
         * Written by: Matthew Smith 25/03/19
         * Authorised by: Panagiotis Petridis
         */
        @Test
        void largeValue() {
            WhatNestApp.UserTransactions = new ArrayList<>();
            WhatNestApp.UserTransactions.add(
                    new WhatNestTransaction("trans1",new BigDecimal("1000000"), 0));
            WhatNestApp.UserCategories = new ArrayList<>();
            WhatNestApp.UserCategories.add(
                    new WhatNestCategory("cat1"));

            WhatNestApp.ListTransactions();
            assertEquals("1) trans1 (cat1) - £1000000.00\n", output.toString());
        }

        /* 3.2.10 - Test with transaction of value 0
         * Written by: Matthew Smith 25/03/19
         * Authorised by: Panagiotis Petridis
         */
        @Test
        void zeroValue() {
            WhatNestApp.UserTransactions = new ArrayList<>();
            WhatNestApp.UserTransactions.add(
                    new WhatNestTransaction("trans1",new BigDecimal("0"), 0));
            WhatNestApp.UserCategories = new ArrayList<>();
            WhatNestApp.UserCategories.add(
                    new WhatNestCategory("cat1"));

            WhatNestApp.ListTransactions();
            assertEquals("1) trans1 (cat1) - £0.00\n", output.toString());
        }

        /* 3.2.11 - Test with transaction of negative value
         * Written by: Matthew Smith 25/03/19
         * Authorised by: Panagiotis Petridis
         */
        @Test
        void negativeValue() {
            WhatNestApp.UserTransactions = new ArrayList<>();
            WhatNestApp.UserTransactions.add(
                    new WhatNestTransaction("trans1",new BigDecimal("-10.21"), 0));
            WhatNestApp.UserCategories = new ArrayList<>();
            WhatNestApp.UserCategories.add(
                    new WhatNestCategory("cat1"));

            WhatNestApp.ListTransactions();
            assertEquals("1) trans1 (cat1) - -£10.21\n", output.toString());
        }
    }

    @AfterAll
    static void disp() {
        System.setOut(System.out);
        System.setIn(System.in);
    }
}