import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.nio.file.Watchable;


class WhatNestTransactionTest {
    @Nested

    class SetTransactionCategory{
        /*
         * Checks for valid transaction category parameter value entered
         * Written by: Berk Demir 28/03/2019
         * Approved by:
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
         * Approved by:
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
         * Approved by:
         */
        void checkZero(){
            WhatNestTransaction z = new WhatNestTransaction();
            assertThrows(Exception.class, ()->{
                z.setTransactionCategory(0);
            });
        }
        /*
         * Checks that value entered corresponds to an available category (not greater than number of available categories)
         * Written by: Berk Demir 28/03/2019
         * Approved by:
         */
        void checkAvailable(){
            WhatNestTransaction a = new WhatNestTransaction();
            assertThrows(Exception.class, ()->{
                a.setTransactionCategory(Integer.MAX_VALUE);
            });
        }

    }

}