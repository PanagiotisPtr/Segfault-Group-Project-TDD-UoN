package WhatNestTransactionTest;

import WhatNest.WhatNestTransaction;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Calendar;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("1.06 - WhatNestTransactionTest.TransactionTime")
class TransactionTime {
    /* Ensure the date is handled before EPOCH - 1.6.1
     * Written by: Panagiotis Petridis 29/03/19
     * Authorised by: Berk Demir
     */
    @Test
    @DisplayName("1.6.1 - Ensure the date is handled before EPOCH")
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
    @DisplayName("1.6.2 - Ensure the date is handled after EPOCH")
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
    @DisplayName("1.6.3 - Ensure leap years are handled properly")
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
    @DisplayName("1.6.4 - Check for the 2038 problem (EPOCH overflow)")
    void testEpochOverflow() {
        WhatNestTransaction testTransaction = new WhatNestTransaction();
        Calendar cal = Calendar.getInstance();
        cal.set(2999, Calendar.DECEMBER, 31, 23, 59, 00);
        Date date = cal.getTime();
        testTransaction.setTransactionTime(date);
        assertEquals(date, testTransaction.transactionTime());
    }
}
