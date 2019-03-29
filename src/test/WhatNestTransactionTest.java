import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class WhatNestTransactionTest {

    @Nested
    class toString {

        /*
         * Checks for a clear representation (valid transaction date, name and value)
         * Written by: Tara Dilley 28/03/2019
         * Approved by: Panagiotis Petridis
         */

        @Test
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
        void checkParameters1() {
            assertThrows(Exception.class, () -> {
                new WhatNestTransaction("Spending", null , 4);
            });
        }

        /*
         * Checks transactionName is not missing
         * Written by: Tara Dilley 28/03/2019
         * Approved by: Panagiotis Petridis
         */
        @Test
        void checkParameters2() {
            BigDecimal num = new BigDecimal("39.99");
            assertThrows(Exception.class, () -> {
                new WhatNestTransaction(null, num , 4);
            });
        }

        /*
         * Checks transactionName and transactionValue are not missing
         * Written by: Tara Dilley 28/03/2019
         * Approved by: Panagiotis Petridis
         */
        @Test
        void checkParameters3() {
            assertThrows(Exception.class, () -> {
                new WhatNestTransaction(null, null , 4);
            });
        }
    }
}