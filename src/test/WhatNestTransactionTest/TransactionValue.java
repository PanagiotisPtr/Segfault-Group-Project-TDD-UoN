package WhatNestTransactionTest;

import WhatNest.WhatNestTransaction;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("1.04 - WhatNestTransactionTest.TransactionValue")
class TransactionValue {
    /* Ensure that the value can handle very small numbers - 1.4.1
     * Written by: Panagiotis Petridis 29/03/19
     * Authorised by: Tara Dilley
     */
    @Test
    @DisplayName("1.4.1 - Ensure that the value can handle very small numbers")
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
    @DisplayName("1.4.2 - Check that NULL is handled properly")
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
    @DisplayName("1.4.3 - Ensure that the value can handle huge numbers")
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
    @DisplayName("1.4.4 - Check that the value can handle normal numbers")
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
