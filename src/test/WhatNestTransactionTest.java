import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

class WhatNestTransactionTest {
    @Nested
    class TransactionValue {
        /* Ensure that the value can handle very small numbers - 1.4.1
         * Written by: Panagiotis Petridis 29/03/19
         * Authorised by: Tara Dilley
         */
        @Test
        void testSmallNumbersConstructor() {
            WhatNestTransaction testTransaction =
                    new WhatNestTransaction("test", new BigDecimal("0.01"), 0);
            assertEquals(new BigDecimal("0.01"),
                    testTransaction.transactionValue());

            // Test with setTransactionValue()
            testTransaction.setTransactionValue(new BigDecimal("0.01"));
            assertEquals(new BigDecimal("0.01"),
                    testTransaction.transactionValue());
        }

        /* Check that NULL is handled properly - 1.4.2
         * Written by: Panagiotis Petridis 29/03/19
         * Authorised by: Tara Dilley
         */
        @Test
        void testNullNumbersConstructor() {
            // Test with constructor
            WhatNestTransaction testTransaction =
                    new WhatNestTransaction("test", null, 0);
            assertEquals(null, testTransaction.transactionValue());

            // Test with setTransactionValue()
            testTransaction.setTransactionValue(null);
            assertEquals(null, testTransaction.transactionValue());
        }

        /* Ensure that the value can handle huge numbers - 1.4.3
         * Written by: Panagiotis Petridis 29/03/19
         * Authorised by: Tara Dilley
         */
        @Test
        void testHugeNumbersConstructor() {
            // Test with constructor
            WhatNestTransaction testTransaction =
                    new WhatNestTransaction("test",
                            new BigDecimal("1000000000"),0);
            assertEquals(new BigDecimal("1000000000"),
                    testTransaction.transactionValue());

            // Test with setTransactionValue()
            testTransaction.setTransactionValue(new BigDecimal("1000000000"));
            assertEquals(new BigDecimal("1000000000"),
                    testTransaction.transactionValue());
        }

        /* Check that the value can handle normal numbers - 1.4.4
         * Written by: Panagiotis Petridis 29/03/19
         * Authorised by: Tara Dilley
         */
        @Test
        void testNormalNumbersConstructor() {
            // Test with constructor
            WhatNestTransaction testTransaction =
                    new WhatNestTransaction("test", new BigDecimal("100"), 0);
            assertEquals(new BigDecimal("100"),
                    testTransaction.transactionValue());

            // Test with setTransactionValue()
            testTransaction.setTransactionValue(new BigDecimal("100"));
            assertEquals(new BigDecimal("100"),
                    testTransaction.transactionValue());
        }
    }
}