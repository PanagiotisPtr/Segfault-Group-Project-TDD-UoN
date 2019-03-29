import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class WhatNestTransactionTest {
    @Nested
    class IsComplete{

        /*
         * Test complete name and complete value
         * Written by: Berk Demir 28/03/2019
         * Approved by: Panagiotis Petridis
         */
        @Test
        void allComplete(){
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
        void nameComplete(){
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
        void valueComplete(){
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
        void nothingComplete() {
            WhatNestTransaction t = new WhatNestTransaction();
            assertFalse(t.isComplete());
        }
    }
}