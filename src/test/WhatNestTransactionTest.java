import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class WhatNestTransactionTest {
    @Nested
    class DefaultConstructor {

        /*
            * Ensure correct category is set for unknown transaction (0)
            * Written by: Matthew Smith 25/03/2019
            * Approved by: Panagiotis Petridis
            */
        @Test
        void initialCategory() {
            WhatNestTransaction transaction = new WhatNestTransaction();
            assertEquals(0,transaction.transactionCategory());
        }

        /*
            * Ensure correct name is set for transaction
            * (it should be  "[Pending Transaction]")
            * Written by: Matthew Smith 25/03/2019
            * Approved by: Panagiotis Petridis
            */
        @Test
        void initialName() {
            WhatNestTransaction transaction = new WhatNestTransaction();
            assertEquals("[Pending transaction]",
                    transaction.transactionName());
        }

        /*
            * Ensure correct value is set for unknown transaction (null)
            * Written by: Matthew Smith 25/03/2019
            * Approved by: Panagiotis Petridis
            */
        @Test
        void initialValue() {
            WhatNestTransaction transaction = new WhatNestTransaction();
            assertEquals(null,transaction.transactionValue());
        }

        /*
            * Ensure correct time is set for unknown transaction
            * Written by: Matthew Smith 25/03/2019
            * Approved by: Panagiotis Petridis
            */
        @Test
        void initialTime() {
            Date before = new Date();
            WhatNestTransaction transaction = new WhatNestTransaction();
            Date after = new Date();

            assertTrue(transaction.transactionTime().compareTo(before) >= 0
                    && transaction.transactionTime().compareTo(after) <= 0);
        }
    }
    
    @Nested
    class MainConstructor{

        /*
         * Checks that it works with completely correct values
         * Written by: Tara Dilley 27/03/2019
         * Approved by: Panagiotis Petridis
         */
        @Test
        void validInputCheck() {
            BigDecimal num = new BigDecimal("35.99");
            WhatNestTransaction transaction = 
                new WhatNestTransaction("hello", num, 4);
            assertEquals("hello", transaction.transactionName());
            assertEquals(num, transaction.transactionValue());
            assertEquals(4, transaction.transactionCategory());
        }

        /*
         * Checks that Transaction name is not too long
         * Written by Tara Dilley 27/03/2019
         * Approved by: Panagiotis Petridis
         */
        @Test
        void checkNameLength() {
            BigDecimal num = new BigDecimal("35.99");
            WhatNestTransaction transaction =
                new WhatNestTransaction("abcdefghijklmnopqrstuvwxyz", num, 4);
            assertEquals("abcdefghijklmnopqrstuvwxy", 
                         transaction.transactionName());
        }

        /*
         * Checks that Transaction name has been entered
         * Written by Tara Dilley 27/03/2019
         * Approved by: Panagiotis Petridis
        */
        @Test
        void checkNameNotNull() {
            BigDecimal num = new BigDecimal("35.99");
            assertThrows(Exception.class, () -> {
                new WhatNestTransaction("", num, 4);
            });
        }

        /*
         * Checks that Transaction value is not less than 0
         * Written by Tara Dilley 27/03/2019
         * Approved by: Panagiotis Petridis
        */
        @Test
        void checkValueNotNegative(){
            BigDecimal num = new BigDecimal("-1");
            assertThrows(Exception.class, () -> {
                new WhatNestTransaction("hello", num, 4);
            });
        }

        /*
         * Checks that Transaction value is greater than 0
         * Written by Tara Dilley 27/03/2019
         * Approved by: Panagiotis Petridis
        */
        @Test
        void checkValueNotZero() {
            BigDecimal num = new BigDecimal("0");
            assertThrows(Exception.class, () -> {
                new WhatNestTransaction("hello", num, 4);
            });
        }

        /*
         * Checks that Transaction Name can be in unicode
         * Written by Tara Dilley 27/03/2019
         * Approved by: Panagiotis Petridis
        */
        @Test
        void checkUnicode() {
            BigDecimal num = new BigDecimal("35.99");
            WhatNestTransaction transaction = 
                new WhatNestTransaction("σφαλμα", num, 4);
            assertEquals("σφαλμα", transaction.transactionName());
        }

        /*
         * Check for very large Transaction values entered
         * Written by Tara Dilley 27/03/2019
         * Approved by: Panagiotis Petridis
        */
        @Test
        void checkLargeValues() {
            BigDecimal num = new BigDecimal("1000000");
            WhatNestTransaction transaction =
                new WhatNestTransaction("hello", num, 4);
            assertEquals(0, transaction.transactionValue().compareTo(num));

        }

        /*
         * Check for correct time value
         * Written by Tara Dilley 27/03/2019
         * Approved by: Panagiotis Petridis
        */
        @Test
        void checkTimeValues() {
            Date before = new Date();
            BigDecimal num = new BigDecimal("35.99");
            WhatNestTransaction transaction = new WhatNestTransaction("hello", num, 4);
            Date after = new Date();
            assertTrue(transaction.transactionTime().compareTo(before) >= 0);
            assertTrue(transaction.transactionTime().compareTo(after) <= 0);
        }
    }

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
