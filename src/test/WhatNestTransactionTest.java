import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

class WhatNestTransactionTest {
    @Nested
    class TransactionCategory {

        /* Check that the value can handle zero - 1.5.1
         * Written by: Panagiotis Petridis 29/03/19
         * Authorised by: Lars Lunde
         */
        @Test
        void testZeroCategoryConstructor() {
            // Test with constructor
            WhatNestTransaction testTransaction =
                    new WhatNestTransaction("test", new BigDecimal("0"), 0);
            assertEquals(0, testTransaction.transactionCategory());

            // Test with setTransactionCategory()
            testTransaction.setTransactionCategory(0);
            assertEquals(0, testTransaction.transactionCategory());
        }

        /* Check that the value can handle negative numbers - 1.5.2
         * Written by: Panagiotis Petridis 29/03/19
         * Authorised by: Lars Lunde
         */
        @Test
        void testNegativeCategoryConstructor() {
            // Test with constructor
            WhatNestTransaction testTransaction =
                    new WhatNestTransaction("test", new BigDecimal("0"), -10);
            assertEquals(-10, testTransaction.transactionCategory());

            // Test with setTransactionCategory()
            testTransaction.setTransactionCategory(-10);
            assertEquals(-10, testTransaction.transactionCategory());
        }

        /* Check that the value can handle positive numbes - 1.5.3
         * Written by: Panagiotis Petridis 29/03/19
         * Authorised by: Lars Lunde
         */
        @Test
        void testPositiveCategoryConstructor() {
            // Test with constructor
            WhatNestTransaction testTransaction =
                    new WhatNestTransaction("test", new BigDecimal("0"), 10);
            assertEquals(10, testTransaction.transactionCategory());

            // Test with setTransactionCategory()
            testTransaction.setTransactionCategory(10);
            assertEquals(10, testTransaction.transactionCategory());
        }
    }
}