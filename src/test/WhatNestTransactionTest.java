import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class WhatNestTransactionTest {
    @Nested
    class TransactionName {
        /*Tests for 1.3.*
          Written by: Panagiotis Petridis
          Date: 25/03/2019
          Authorised by:
        */

        // Test normal strings - 1.3.1

        // Test with constructor
        @Test
        void normalStringConstructor() {
            WhatNestTransaction testTransaction =
                    new WhatNestTransaction("test123", new BigDecimal(0), 0);
            assertEquals("test123", testTransaction.transactionName());
        }

        // Test with setTransactionName()
        @Test
        void normalStringSetFunction() {
            WhatNestTransaction testTransaction = new WhatNestTransaction();
            testTransaction.setTransactionName("test123");
            assertEquals("test123", testTransaction.transactionName());
        }

        // Test unicode strings - 1.3.2

        // Test with constructor
        @Test
        void unicodeStringConstructor() {
            WhatNestTransaction testTransaction =
                    new WhatNestTransaction("σφάλμα", new BigDecimal(0), 0);
            assertEquals("σφάλμα", testTransaction.transactionName());
        }

        // Test with setTransactionName()
        @Test
        void unicodeStringSetFunction() {
            WhatNestTransaction testTransaction = new WhatNestTransaction();
            testTransaction.setTransactionName("σφάλμα");
            assertEquals("σφάλμα", testTransaction.transactionName());
        }
    }
}