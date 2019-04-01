package WhatNestTransactionTest;

import WhatNest.WhatNestTransaction;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("1.05 - WhatNestTransactionTest.TransactionCategory")
class TransactionCategory {
    /* Check that the value can handle zero - 1.5.1
     * Written by: Panagiotis Petridis 29/03/19
     * Authorised by: Lars Lunde
     */
    @Test
    @DisplayName("1.5.1 - Check that the value can handle zero")
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
    @DisplayName("1.5.2 - Check that the value can handle negative numbers")
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
    @DisplayName("1.5.3 - Check that the value can handle positive numbes")
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
