import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WhatNestTransactionTest {
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

}