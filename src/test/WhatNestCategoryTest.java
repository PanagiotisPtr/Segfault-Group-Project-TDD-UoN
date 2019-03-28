import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;


class WhatNestCategoryTest {
    @Nested
    class DefaultConstructor{

        /*
         * Check that it meets specification
         * Written by: Berk Demir 28/03/2019
         * Approved by:
         */
        @Test
        void checkCreate(){
            WhatNestCategory cat = new WhatNestCategory("Example");
            assertEquals("Example", cat.CategoryName());
        }

        /*
         * Create 2 classes with same name make sure it gives error
         * Written by: Berk Demir 28/03/2019
         * Approved by:
         */
        @Test
        void checkDuplicate(){
            WhatNestCategory dup = new WhatNestCategory("Example");
            assertThrows(Exception.class, ()->{
                WhatNestCategory dup2 = new WhatNestCategory("Example");
            });
        }

        /*
         * Make sure that class has spend and budget to 0 and not an arbitrary value
         * Written by: Berk Demir 28/03/2019
         * Approved by:
         */
        @Test
        void checkZeros(){
            WhatNestCategory def = new WhatNestCategory("Example");
            BigDecimal zero = new BigDecimal(0);
            assertEquals(0, def.CategorySpend().compareTo(zero));
            assertEquals(0, def.CategoryBudget().compareTo(zero));
        }
        /*
         * Check Unicode characters
         * Written by: Berk Demir 28/03/2019
         * Approved by:
         */
        void checkUnicode(){
            WhatNestCategory uni = new WhatNestCategory("σφαλμα");
            assertEquals("σφαλμα", uni.CategoryName());
        }
        /*
         * Check that default constructor handles long names
         * Written by: Berk Demir 28/03/2019
         * Approved by:
         */
        @Test
        void checkLongName() {
            assertThrows(Exception.class, ()->{
                WhatNestCategory lng = new WhatNestCategory("AVeryVeryVeryLongLongLongName");
            });
        }

        /*
         * Check that it handles empty names
         * Written by: Berk Demir 28/03/2019
         * Approved by:
         */
        @Test
        void checkBlank(){
            assertThrows(Exception.class, ()->{
                WhatNestCategory blank = new WhatNestCategory("");
            });
        }


    }

}