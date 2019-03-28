import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class WhatNestCategoryTest {
    @Nested
    class TestSetCategoryBudget {

        /*
         * Test that it accepts floats
         * Written by: Lars Lunde 28/03/2019
         * Approved by:
         */
        @Test
        void baseCase() {
            WhatNestCategory cat = new WhatNestCategory("Example");
            BigDecimal tmp = new BigDecimal("2500.01");
            cat.setCategoryBudget(tmp);
            assertEquals(0, cat.CategoryBudget().compareTo(tmp));
        }

        /*
         * Test that it accepts floats
         * Written by: Lars Lunde 28/03/2019
         * Approved by:
         */
        @Test
        void negativeCase() {
            WhatNestCategory cat = new WhatNestCategory("Example");
            BigDecimal tmp = new BigDecimal("-2.5");
            assertThrows(Exception.class, () -> {
                cat.setCategoryBudget(tmp);
            });
        }

        /*
         * Check very large numbers
         * Written by: Lars Lunde 28/03/2019
         * Approved by:
         */
        @Test
        void largeNumber() {
            WhatNestCategory cat = new WhatNestCategory("Example");
            BigDecimal tmp = new BigDecimal("999999.99999999900");
            cat.setCategoryBudget(tmp);
            assertEquals(0, cat.CategoryBudget().compareTo(tmp));
        }
    }
}