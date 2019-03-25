import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

class WhatNestTransactionTest {
    @Nested
    class TransactionCategory {
        /*Tests for 1.5.*
          Written by: Panagiotis Petridis
          Date: 25/03/2019
          Authorised by:
        */

        // Check that the value can handle zero - 1.5.1

        // Test with constructor
        @Test
        void testZeroCategoryConstructor() {
            WhatNestTransaction testTransaction =
                    new WhatNestTransaction("test", new BigDecimal("0"), 0);
            assertEquals(0, testTransaction.transactionCategory());
        }

        // Test with setTransactionCategory()
        @Test
        void testZeroCategorySetFunction() {
            WhatNestTransaction testTransaction = new WhatNestTransaction();
            testTransaction.setTransactionCategory(0);
            assertEquals(0, testTransaction.transactionCategory());
        }

        // Check that the value can handle negative numbers - 1.5.2

        // Test with constructor
        @Test
        void testNegativeCategoryConstructor() {
            WhatNestTransaction testTransaction =
                    new WhatNestTransaction("test", new BigDecimal("0"), -10);
            assertEquals(-10, testTransaction.transactionCategory());
        }

        // Test with setTransactionCategory()
        @Test
        void testNegativeCategorySetFunction() {
            WhatNestTransaction testTransaction = new WhatNestTransaction();
            testTransaction.setTransactionCategory(-10);
            assertEquals(-10, testTransaction.transactionCategory());
        }

        // Check that the value can handle positive numbes - 1.5.3

        // Test with constructor
        @Test
        void testPositiveCategoryConstructor() {
            WhatNestTransaction testTransaction =
                    new WhatNestTransaction("test", new BigDecimal("0"), 10);
            assertEquals(10, testTransaction.transactionCategory());
        }

        // Test with setTransactionCategory()
        @Test
        void testPositiveCategorySetFunction() {
            WhatNestTransaction testTransaction = new WhatNestTransaction();
            testTransaction.setTransactionCategory(10);
            assertEquals(10, testTransaction.transactionCategory());
        }

    }
}