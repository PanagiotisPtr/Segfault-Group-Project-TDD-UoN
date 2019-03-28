import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class WhatNestTransactionTest {
        @Nested
        class DefaultConstructor {

            /*
             * Ensure correct category is set for unknown transaction (0)
             * Written by: Matthew Smith 25/03/2019
             * Approved by: Panagiotis Petridis
             */
            @Test
            void initialCategory() {
                WhatNestTransaction transaction = new WhatNestTransaction();
                assertEquals(0,transaction.transactionCategory());
            }

            /*
             * Ensure correct name is set for transaction
             * (it should be  "[Pending Transaction]")
             * Written by: Matthew Smith 25/03/2019
             * Approved by: Panagiotis Petridis
             */
            @Test
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
            void initialTime() {
                Date before = new Date();
                WhatNestTransaction transaction = new WhatNestTransaction();
                Date after = new Date();

                assertTrue(transaction.transactionTime().compareTo(before) >= 0
                        && transaction.transactionTime().compareTo(after) <= 0);
            }
        }
    }
}