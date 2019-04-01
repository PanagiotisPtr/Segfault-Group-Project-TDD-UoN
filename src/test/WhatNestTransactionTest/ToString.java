package WhatNestTransactionTest;

import WhatNest.WhatNestTransaction;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@DisplayName("1.11 - WhatNestTransactionTest.ToString")
class ToString {
    /*
     * Checks for a clear representation (valid transaction date, name and value)
     * Written by: Tara Dilley 28/03/2019
     * Approved by: Panagiotis Petridis
     */
    @Test
    @DisplayName("1.11.1 - Checks for a clear representation (valid transaction date, name and value)")
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
    @DisplayName("1.11.2 - Checks transactionValue is not missing")
    void checkParameters1() {
        assertThrows(Exception.class, () -> {
            new WhatNestTransaction("Spending", null, 4);
        });
    }
    /*
     * Checks transactionName is not missing
     * Written by: Tara Dilley 28/03/2019
     * Approved by: Panagiotis Petridis
     */
    @Test
    @DisplayName("1.11.3 - Checks transactionName is not missing")
    void checkParameters2() {
        BigDecimal num = new BigDecimal("39.99");
        assertThrows(Exception.class, () -> {
            new WhatNestTransaction(null, num, 4);
        });
    }
    /*
     * Checks transactionName and transactionValue are not missing
     * Written by: Tara Dilley 28/03/2019
     * Approved by: Panagiotis Petridis
     */
    @Test
    @DisplayName("1.11.4 - Checks transactionName and transactionValue are not missing")
    void checkParameters3() {
        assertThrows(Exception.class, () -> {
            new WhatNestTransaction(null, null, 4);
        });
    }
}

