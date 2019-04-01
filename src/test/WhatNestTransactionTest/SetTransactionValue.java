package WhatNestTransactionTest;

import WhatNest.WhatNestTransaction;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@DisplayName("1.08 - WhatNestTransactionTest.SetTransactionValue")
class SetTransactionValue {
    /*
     * Checks for a valid parameter of type BigDecimal
     * Written by: Berk Demir 28/03/2019
     * Approved by: Panagiotis Petridis
     */
    @Test
    @DisplayName("1.8.1 - Checks for a valid parameter of type BigDecimal")
    void checkValidParameter() {
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
    @DisplayName("1.8.2 - Checks that negative parameter values are not allowed")
    void checkNegative() {
        WhatNestTransaction ng = new WhatNestTransaction();
        assertThrows(Exception.class, () -> {
            ng.setTransactionValue(new BigDecimal(-4.3));
        });
    }
    /*
     * Checks that parameter value is greater than zero
     * Written by: Berk Demir 28/03/2019
     * Approved by: Panagiotis Petridis
     */
    @Test
    @DisplayName("1.8.3 - Checks that parameter value is greater than zero")
    void checkZero() {
        WhatNestTransaction z = new WhatNestTransaction();
        assertThrows(Exception.class, () -> {
            z.setTransactionValue(new BigDecimal(0));
        });
    }
    /*
     * Checks that Transaction value has not already been set
     * Written by: Berk Demir 28/03/2019
     * Approved by: Panagiotis Petridis
     */
    @Test
    @DisplayName("1.8.4 - Checks that Transaction value has not already been set")
    void checkDuplicate() {
        WhatNestTransaction d = new WhatNestTransaction();
        d.setTransactionValue(new BigDecimal(3));
        assertThrows(Exception.class, () -> {
            d.setTransactionValue(new BigDecimal(2));
        });
    }
    /*
     * Checks for very large transaction values entered
     * Written by: Berk Demir 28/03/2019
     * Approved by: Panagiotis Petridis
     */
    @Test
    @DisplayName("1.8.5 - Checks for very large transaction values entered")
    void checkSize() {
        WhatNestTransaction size = new WhatNestTransaction();
        assertThrows(Exception.class,() -> {
            size.setTransactionValue(new BigDecimal("254387435084527052"));
        });
    }
}
