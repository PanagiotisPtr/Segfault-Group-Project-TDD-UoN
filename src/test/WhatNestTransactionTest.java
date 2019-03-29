import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

class WhatNestTransactionTest {
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
}