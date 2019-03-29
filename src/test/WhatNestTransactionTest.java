import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Calendar;

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

    @Nested
    class TransactionTime {
        /* Ensure the date is handled before EPOCH - 1.6.1
         * Written by: Panagiotis Petridis 29/03/19
         * Authorised by: Berk Demir
         */
        @Test
        void testBeforeEpoch() {
            WhatNestTransaction testTransaction = new WhatNestTransaction();

            Calendar cal = Calendar.getInstance();
            cal.set(1958, Calendar.OCTOBER, 31, 18, 00, 00);
            Date date = cal.getTime();

            testTransaction.setTransactionTime(date);

            assertEquals(date, testTransaction.transactionTime());
        }

        /* Ensure the date is handled after EPOCH - 1.6.2
         * Written by: Panagiotis Petridis 29/03/19
         * Authorised by: Berk Demir
         */
        @Test
        void testAfterEpoch() {
            WhatNestTransaction testTransaction = new WhatNestTransaction();

            Calendar cal = Calendar.getInstance();
            cal.set(2014, Calendar.NOVEMBER, 8, 13, 44, 00);
            Date date = cal.getTime();

            testTransaction.setTransactionTime(date);

            assertEquals(date, testTransaction.transactionTime());
        }

        /* Ensure leap years are handled properly - 1.6.3
         * Written by: Panagiotis Petridis 29/03/19
         * Authorised by: Berk Demir
         */
        @Test
        void testLeapYear() {
            WhatNestTransaction testTransaction = new WhatNestTransaction();

            Calendar cal = Calendar.getInstance();
            cal.set(20000, Calendar.FEBRUARY, 29, 20, 00, 00);
            Date date = cal.getTime();

            testTransaction.setTransactionTime(date);

            assertEquals(date, testTransaction.transactionTime());
        }

        /* Check for the 2038 problem (EPOCH overflow) - 1.6.4
         * Written by: Panagiotis Petridis 29/03/19
         * Authorised by: Berk Demir
         */
        @Test
        void testEpochOverflow() {
            WhatNestTransaction testTransaction = new WhatNestTransaction();

            Calendar cal = Calendar.getInstance();
            cal.set(2999, Calendar.DECEMBER, 31, 23, 59, 00);
            Date date = cal.getTime();

            testTransaction.setTransactionTime(date);

            assertEquals(date, testTransaction.transactionTime());
        }
    }

    @Nested
    class SetTransactionName{


        /*
         * Checks for valid string parameter
         * Written by: Berk Demir 28/03/2019
         * Approved by:
         */
        @Test
        void checkString(){
            WhatNestTransaction n = new WhatNestTransaction();
            n.setTransactionName("hello");
            assertEquals("hello", n.transactionName());
        }
        /*
         * Checks that method will truncate long strings
         * Written by: Berk Demir 28/03/2019
         * Approved by:
         */
        @Test
        void checkLength(){
            WhatNestTransaction l = new WhatNestTransaction();
            l.setTransactionName("abcdefghijklmonpqrstuvwxyz");
            assertEquals("abcdefghijklmonpqrstuvwxy", l.transactionName());
        }

        /*
         * Checks that Transaction Name hasn't already been set
         * Written by: Berk Demir 28/03/2019
         * Approved by:
         */
        @Test
        void checkDuplicate(){
            WhatNestTransaction d = new WhatNestTransaction();
            d.setTransactionName("hello");
            assertThrows(Exception.class, ()->{
                d.setTransactionName("hello");
            });
        }

        /*
         * Checks that reserved name is not used
         * Written by: Berk Demir 28/03/2019
         * Approved by:
         */
        @Test
        void checkReserve(){
            WhatNestTransaction r = new WhatNestTransaction();
            assertThrows(Exception.class, () -> {
                r.setTransactionName("[Pending Transaction]");
            });

        }
    }

    @Nested
    class SetTransactionValue{
        /*
         * Checks for a valid parameter of type BigDecimal
         * Written by: Berk Demir 28/03/2019
         * Approved by: Panagiotis Petridis
         */
        @Test
        void checkValidParameter(){
            WhatNestTransaction bd = new WhatNestTransaction();
            bd.setTransactionValue(new BigDecimal(3.99));
            assertEquals(0, bd.transactionValue().compareTo(new BigDecimal(3.99)));
        }
        /*
         * Checks that negative parameter values are not allowed
         * Written by: Berk Demir 28/03/2019
         * Approved by: Panagiotis Petridis
         */
        @Test
        void checkNegative(){
            WhatNestTransaction ng = new WhatNestTransaction();
            assertThrows(Exception.class, ()->{
                ng.setTransactionValue(new BigDecimal(-4.3));
            });
        }
        /*
         * Checks that parameter value is greater than zero
         * Written by: Berk Demir 28/03/2019
         * Approved by: Panagiotis Petridis
         */
        @Test
        void checkZero(){
            WhatNestTransaction z = new WhatNestTransaction();
            assertThrows(Exception.class, ()->{
                z.setTransactionValue(new BigDecimal(0));
            });
        }
        /*
         * Checks that Transaction value has not already been set
         * Written by: Berk Demir 28/03/2019
         * Approved by: Panagiotis Petridis
         */
        @Test
        void checkDuplicate(){
            WhatNestTransaction d = new WhatNestTransaction();
            d.setTransactionValue(new BigDecimal(3));
            assertThrows(Exception.class, ()->{
                d.setTransactionValue(new BigDecimal(2));
            });
        }
        /*
         * Checks for very large transaction values entered
         * Written by: Berk Demir 28/03/2019
         * Approved by: Panagiotis Petridis
         */
        @Test
        void checkSize(){
            WhatNestTransaction size = new WhatNestTransaction();
            assertThrows(Exception.class,()->{
                size.setTransactionValue(new BigDecimal("254387435084527052"));
            });

        }
    }

    @Nested
    class SetTransactionCategory{
        /*
         * Checks for valid transaction category parameter value entered
         * Written by: Berk Demir 28/03/2019
         * Approved by: Panagiotis Petridis
         */
        @Test
        void checkValid(){
            WhatNestTransaction v = new WhatNestTransaction();
            v.setTransactionCategory(7);
            assertEquals(7, v.transactionCategory());
        }
        /*
         * Checks that value entered corresponds to an available category (non-negative
         * Written by: Berk Demir 28/03/2019
         * Approved by: Panagiotis Petridis
         */
        @Test
        void checkNegative(){
            WhatNestTransaction n = new WhatNestTransaction();
            assertThrows(Exception.class, ()->{
                n.setTransactionCategory(-1);
            });
        }
        /*
         * Checks that value entered corresponds to an available category (non-zero)
         * Written by: Berk Demir 28/03/2019
         * Approved by: Panagiotis Petridis
         */
        @Test
        void checkZero(){
            WhatNestTransaction z = new WhatNestTransaction();
            assertThrows(Exception.class, ()->{
                z.setTransactionCategory(0);
            });
        }
        /*
         * Checks that value entered corresponds to an available category (not greater than number of available categories)
         * Written by: Berk Demir 28/03/2019
         * Approved by: Panagiotis Petridis
         */

        /*
        * Note: This assumes that the maximum number of categories
        * is Integer.MAX_VALUE . We might need a variable that keeps
        * track of the number of categories.
        * */
        @Test
        void checkAvailable(){
            WhatNestTransaction a = new WhatNestTransaction();
            assertThrows(Exception.class, ()->{
                a.setTransactionCategory(Integer.MAX_VALUE);
            });
        }
    }

    @Nested
    class IsComplete{

        /*
         * Test complete name and complete value
         * Written by: Berk Demir 28/03/2019
         * Approved by: Panagiotis Petridis
         */
        @Test
        void allComplete(){
            WhatNestTransaction t = new WhatNestTransaction();
            t.setTransactionName("Good");
            t.setTransactionValue(new BigDecimal(10));
            assertTrue(t.isComplete());
        }

        /*
         * Test complete name and incomplete value
         * Written by: Berk Demir 28/03/2019
         * Approved by: Panagiotis Petridis
         */
        @Test
        void nameComplete(){
            WhatNestTransaction t = new WhatNestTransaction();
            t.setTransactionName("Good");
            assertFalse(t.isComplete());
        }
        /*
         * Test incomplete name and complete value
         * Written by: Berk Demir 28/03/2019
         * Approved by: Panagiotis Petridis
         */
        @Test
        void valueComplete(){
            WhatNestTransaction t = new WhatNestTransaction();
            t.setTransactionValue(new BigDecimal(10));
            assertFalse(t.isComplete());
        }
        /*
         * Test incomplete name and incomplete value
         * Written by: Berk Demir 28/03/2019
         * Approved by: Panagiotis Petridis
         */
        @Test
        void nothingComplete() {
            WhatNestTransaction t = new WhatNestTransaction();
            assertFalse(t.isComplete());
        }
    }

    @Nested
    class toString {

        /*
         * Checks for a clear representation (valid transaction date, name and value)
         * Written by: Tara Dilley 28/03/2019
         * Approved by: Panagiotis Petridis
         */

        @Test
        void clearRepresentation() {
            Date before = new Date();
            BigDecimal num = new BigDecimal("39.99");
            WhatNestTransaction transaction = new WhatNestTransaction("Spending", num, 4);
            assertEquals("Spending - £" + num + " " + before, transaction.toString());
        }

        /*
         * Checks transactionValue is not missing
         * Written by: Tara Dilley 28/03/2019
         * Approved by: Panagiotis Petridis
         */
        @Test
        void checkParameters1() {
            assertThrows(Exception.class, () -> {
                new WhatNestTransaction("Spending", null , 4);
            });
        }

        /*
         * Checks transactionName is not missing
         * Written by: Tara Dilley 28/03/2019
         * Approved by: Panagiotis Petridis
         */
        @Test
        void checkParameters2() {
            BigDecimal num = new BigDecimal("39.99");
            assertThrows(Exception.class, () -> {
                new WhatNestTransaction(null, num , 4);
            });
        }

        /*
         * Checks transactionName and transactionValue are not missing
         * Written by: Tara Dilley 28/03/2019
         * Approved by: Panagiotis Petridis
         */
        @Test
        void checkParameters3() {
            assertThrows(Exception.class, () -> {
                new WhatNestTransaction(null, null , 4);
            });
        }
    }
}
