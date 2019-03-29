import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class WhatNestTransactionTest {
    @Nested
    class TransactionName {
        /* Test normal strings - 1.3.1
         * Written by: Panagiotis Petridis 29/03/19
         * Authorised by: Berk Demir
         */
        @Test
        void normalStringConstructor() {
            // Test with constructor
            WhatNestTransaction testTransaction =
                    new WhatNestTransaction("test123", new BigDecimal(0), 0);
            assertEquals("test123", testTransaction.transactionName());
            // Test with set function
            testTransaction.setTransactionName("123test");
            assertEquals("123test", testTransaction.transactionName());
        }

        /* Test unicode strings - 1.3.2
         * Written by: Panagiotis Petridis 29/03/19
         * Authorised by: Berk Demir
         */
        @Test
        void unicodeStringConstructor() {
            // Test with constructor
            WhatNestTransaction testTransaction =
                    new WhatNestTransaction("σφάλμα", new BigDecimal(0), 0);
            assertEquals("σφάλμα", testTransaction.transactionName());

            // Test with set function
            testTransaction.setTransactionName("σφάλμα");
            assertEquals("σφάλμα", testTransaction.transactionName());
        }
    }
}