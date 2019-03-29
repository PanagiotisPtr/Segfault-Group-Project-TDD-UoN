import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.Calendar;


class WhatNestTransactionTest {
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
}