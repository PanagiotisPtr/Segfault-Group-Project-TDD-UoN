package WhatNestTransactionTest;

import WhatNest.WhatNestTransaction;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("1.01 - WhatNestTransactionTest.DefaultConstructor")
class DefaultConstructor {
    /*
     * Ensure correct category is set for unknown transaction (0)
     * Written by: Matthew Smith 25/03/2019
     * Approved by: Panagiotis Petridis
     */
    @Test
    @DisplayName("1.1.1 - Ensure correct category is set for unknown transaction (0)")
    void initialCategory() {
        WhatNestTransaction transaction = new WhatNestTransaction();
        assertEquals(0,transaction.transactionCategory());
    }
    /*
     * Ensure correct name is set for transaction
     * Written by: Matthew Smith 25/03/2019
     * Approved by: Panagiotis Petridis
     */
    @Test
    @DisplayName("1.1.2 - Ensure correct name is set for transaction")
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
    @DisplayName("1.1.3 - Ensure correct value is set for unknown transaction (null)")
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
    @DisplayName("1.1.4 - Ensure correct time is set for unknown transaction")
    void initialTime() {
        Date before = new Date();
        WhatNestTransaction transaction = new WhatNestTransaction();
        Date after = new Date();
        assertTrue(transaction.transactionTime().compareTo(before) >= 0
                && transaction.transactionTime().compareTo(after) <= 0);
    }
}
