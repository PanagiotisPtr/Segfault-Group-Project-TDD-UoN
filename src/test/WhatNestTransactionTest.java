import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Date;


import static org.junit.jupiter.api.Assertions.*;

class WhatNestTransactionTest {
    @Nested
    class MainConstructor{

        /*
         * Checks that it works with completely correct values
         * Written by: Tara Dilley 27/03/2019
         * Approved by:
         */
        @Test
        void validInputCheck(){

            BigDecimal num = new BigDecimal("35.99");
            WhatNestTransaction transaction = new WhatNestTransaction("hello", num, 4);
            assertEquals("hello", transaction.transactionName());
            assertEquals(num, transaction.transactionValue());
            assertEquals(4, transaction.transactionCategory());

        }

        /*
         * Checks that Transaction name is not too long
         * Written by Tara Dilley 27/03/2019
         * Approved by:
         */
         @Test
         void checkNameLength(){
             BigDecimal num = new BigDecimal("35.99");
             WhatNestTransaction transaction = new WhatNestTransaction("abcdefghijklmnopqrstuvwxyz", num, 4);
             assertEquals("abcdefghijklmnopqrstuvwxy", transaction.transactionName());
         }

        /*
         * Checks that Transaction name has been entered
         * Written by Tara Dilley 27/03/2019
         * Approved by:
        */
        @Test
        void checkNameNotNull(){
            BigDecimal num = new BigDecimal("35.99");
            assertThrows(Exception.class, () -> {new WhatNestTransaction("", num, 4);});
        }

        /*
         * Checks that Transaction value is not less than 0
         * Written by Tara Dilley 27/03/2019
         * Approved by:
        */
        @Test
        void checkValueNotNegative(){
            BigDecimal num = new BigDecimal("-1");
            assertThrows(Exception.class, () -> {new WhatNestTransaction("hello", num, 4);});
        }


        /*
         * Checks that Transaction value is greater than 0
         * Written by Tara Dilley 27/03/2019
         * Approved by:
        */
        @Test
        void checkValueNotZero(){
            BigDecimal num = new BigDecimal("0");
            assertThrows(Exception.class, () -> {new WhatNestTransaction("hello", num, 4);});
        }

        /*
         * Checks that Transaction Name can be in unicode
         * Written by Tara Dilley 27/03/2019
         * Approved by:
        */
        @Test
        void checkUnicode(){
            BigDecimal num = new BigDecimal("35.99");
            WhatNestTransaction transaction = new WhatNestTransaction("σφαλμα", num, 4);
            assertEquals("σφαλμα", transaction.transactionName());
        }

        /*
         * Check for very large Transaction values entered
         * Written by Tara Dilley 27/03/2019
         * Approved by:
        */
        @Test
        void checkLargeValues(){
            BigDecimal num = new BigDecimal("1000000");
            WhatNestTransaction transaction = new WhatNestTransaction("hello", num, 4);
            assertEquals(1000000, transaction.transactionValue());

        }

        /*
         * Check for correct time value
         * Written by Tara Dilley 27/03/2019
         * Approved by:
        */
        @Test
        void checkTimeValues(){

            Date before = new Date();
            BigDecimal num = new BigDecimal("35.99");
            WhatNestTransaction transaction = new WhatNestTransaction("hello", num, 4);
            Date after = new Date();
            assertTrue(transaction.transactionTime().compareTo(before) >= 0);
            assertTrue(transaction.transactionTime().compareTo(after) <= 0);

        }

    }

}


