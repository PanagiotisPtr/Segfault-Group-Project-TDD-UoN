package WhatNestTransactionTest;

import WhatNest.WhatNestTransaction;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@DisplayName("1.09 - WhatNestTransactionTest.SetTransactionCategory")
class SetTransactionCategory{
    /*
     * Checks for valid transaction category parameter value entered
     * Written by: Berk Demir 28/03/2019
     * Approved by: Panagiotis Petridis
     */
    @Test
    @DisplayName("1.9.1 - Checks for valid transaction category parameter value entered")
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
    @DisplayName("1.9.2 - Checks that value entered corresponds to an available category (non-negative")
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
    @DisplayName("1.9.3 - Checks that value entered corresponds to an available category (non-zero)")
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
    @DisplayName("1.9.4 - Checks that value entered corresponds to an available category (not greater than number of available categories)")
    void checkAvailable(){
        WhatNestTransaction a = new WhatNestTransaction();
        assertThrows(Exception.class, ()->{
            a.setTransactionCategory(Integer.MAX_VALUE);
        });
    }
}
