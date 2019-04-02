package WhatNestAppTest;

import WhatNest.*;
import org.junit.jupiter.api.*;
import java.io.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("3.04 - WhatNestAppTest.ListTransactionCategory")
class ListTransactionCategory {
    private static ByteArrayOutputStream output;

    @BeforeAll
    static void init() {
        output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));
    }

    @BeforeEach
    void clearOut() {
        output.reset();
        WhatNestApp.UserCategories = new ArrayList<WhatNestCategory>();
        WhatNestApp.UserTransactions = new ArrayList<WhatNestTransaction>();
    }

    @AfterAll
    static void disp() {
        System.setOut(System.out);
        System.setIn(System.in);
    }

    /* 3.4.1 - Test with no category, selecting a non-existing category
     * Written by: Berk Demir & Matthew Smith 02/04/19
     * Authorised by:
     */
    @Test
    @DisplayName("3.4.1 - Test with no category, selecting a non-existing category")
    void noCategory() {
        assertThrows(Exception.class,()-> {
            WhatNestApp.ListTransactionsForCategory(0);
        });
        assertEquals("", output.toString()); //Make sure no output to console.
    }

    /* 3.4.2 - Test with a category with no transactions
     * Written by: Berk Demir & Matthew Smith 02/04/19
     * Authorised by:
     */
    @Test
    @DisplayName("3.4.2 - Test with a category with no transactions")
    void noTransaction() {
        WhatNestCategory cat1 = new WhatNestCategory("cat1");
        cat1.setCategoryBudget(new BigDecimal("20.00"));

        WhatNestApp.ListTransactionsForCategory(0);

        assertEquals("cat1:\n", output.toString());
    }

    /* 3.4.3 - Test a category with 1 transaction
     * Written by: Berk Demir & Matthew Smith 02/04/19
     * Authorised by:
     */
    @Test
    @DisplayName("3.4.3 - Test a category with 1 transaction")
    void oneTransaction() {
        WhatNestCategory cat1 = new WhatNestCategory("cat1");
        cat1.setCategoryBudget(new BigDecimal("20.00"));

        WhatNestApp.ListTransactionsForCategory(0);

        WhatNestTransaction trans1 = new WhatNestTransaction("trans1", new BigDecimal("4.99"),0);
        cat1.addExpense(trans1.transactionValue());
        WhatNestApp.UserTransactions.add(trans1);
        WhatNestApp.ListTransactionsForCategory(0);

        assertEquals("cat1:\n"
                + "1) trans1 (cat1) - £4.99\n", output.toString());
    }

    /* 3.4.4 - Test with a category with 2 transactions
     * Written by: Berk Demir 02/04/19
     * Authorised by:
     */
    @Test
    @DisplayName("3.4.4 - Test a category with 2 transactions")
    void twoTransactions() {
        WhatNestCategory cat1 = new WhatNestCategory("cat1");
        cat1.setCategoryBudget(new BigDecimal("10.00"));

        WhatNestApp.ListTransactionsForCategory(0);

        WhatNestTransaction trans1 = new WhatNestTransaction("trans1", new BigDecimal("4.99"),0);
        WhatNestTransaction trans2 = new WhatNestTransaction("trans2", new BigDecimal("5.01"),0);
        cat1.addExpense(trans1.transactionValue());
        cat1.addExpense(trans2.transactionValue());
        WhatNestApp.UserTransactions.add(trans1);
        WhatNestApp.UserTransactions.add(trans2);
        WhatNestApp.ListTransactionsForCategory(0);

        assertEquals("cat1:\n"
                + "1) trans1 (cat1) - £4.99\n2) trans2 (cat1) - £5.01\n", output.toString());
    }

    /* 3.4.5 - Test 2 categories with a transaction each, make sure one is selected
     * Written by: Berk Demir 02/04/19
     * Authorised by:
     */
    @Test
    @DisplayName("3.4.5 - Test 2 categories with a transaction each, make sure one is selected")
    void twoCategories() {
        WhatNestCategory cat1 = new WhatNestCategory("cat1");
        cat1.setCategoryBudget(new BigDecimal("10.00"));
        WhatNestCategory cat2 = new WhatNestCategory("cat2");
        cat2.setCategoryBudget(new BigDecimal("15.00"));

        WhatNestApp.ListTransactionsForCategory(0);

        WhatNestTransaction trans1 = new WhatNestTransaction("trans1", new BigDecimal("4.99"),0);
        WhatNestTransaction trans2 = new WhatNestTransaction("trans2", new BigDecimal("5.01"),1);
        cat1.addExpense(trans1.transactionValue());
        cat2.addExpense(trans2.transactionValue());
        WhatNestApp.UserTransactions.add(trans1);
        WhatNestApp.UserTransactions.add(trans2);
        WhatNestApp.ListTransactionsForCategory(0);

        assertEquals("cat1:\n"
                + "1) trans1 (cat1) - £4.99\n", output.toString());
    }

    /* 3.4.6 - Test with 2 categories with 2 transactions each, make sure one is selected
     * Written by: Berk Demir 02/04/19
     * Authorised by:
     */
    @Test
    @DisplayName("3.4.6 - Test 2 categories with 2 transactions each, make sure one is selected")
    void twoCatsTwoTransactions() {
        WhatNestCategory cat1 = new WhatNestCategory("cat1");
        cat1.setCategoryBudget(new BigDecimal("10.00"));
        WhatNestCategory cat2 = new WhatNestCategory("cat2");
        cat2.setCategoryBudget(new BigDecimal("15.00"));

        WhatNestApp.ListTransactionsForCategory(0);

        WhatNestTransaction trans1 = new WhatNestTransaction("trans1", new BigDecimal("4.99"),0);
        WhatNestTransaction trans2 = new WhatNestTransaction("trans2", new BigDecimal("5.01"),0);
        WhatNestTransaction trans3 = new WhatNestTransaction("trans3", new BigDecimal("1.00"),1);
        WhatNestTransaction trans4 = new WhatNestTransaction("trans4", new BigDecimal("2.50"),1);
        cat1.addExpense(trans1.transactionValue());
        cat1.addExpense(trans2.transactionValue());
        cat2.addExpense(trans3.transactionValue());
        cat2.addExpense(trans4.transactionValue());

        WhatNestApp.UserTransactions.add(trans1);
        WhatNestApp.UserTransactions.add(trans2);
        WhatNestApp.UserTransactions.add(trans3);
        WhatNestApp.UserTransactions.add(trans4);
        WhatNestApp.ListTransactionsForCategory(1);

        assertEquals("cat2:\n"
                + "3) trans3 (cat2) - £1.00\n"
                + "4) trans4 (cat2) - £2.50\n", output.toString());
    }

}