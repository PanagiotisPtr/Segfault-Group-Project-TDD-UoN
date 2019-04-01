package WhatNestTransactionTest;

import WhatNest.WhatNestTransaction;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("1.10 - WhatNestTransactionTest.IsComplete")
class IsComplete {
    /*
     * Test complete name and complete value
     * Written by: Berk Demir 28/03/2019
     * Approved by: Panagiotis Petridis
     */
    @Test
    @DisplayName("1.10.1 - Test complete name and complete value")
    void allComplete() {
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
    @DisplayName("1.10.2 - Test complete name and incomplete value")
    void nameComplete() {
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
    @DisplayName("1.10.3 - Test incomplete name and complete value")
    void valueComplete() {
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
    @DisplayName("1.10.4 - Test incomplete name and incomplete value")
    void nothingComplete() {
        WhatNestTransaction t = new WhatNestTransaction();
        assertFalse(t.isComplete());
    }
}
