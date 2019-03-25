import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WhatNestCategoryTest {
    @Nested
    class CategoryName{
        /*Tests for 2.3.1
          Written by: Lars Lunde
          Date: 25/03/2019
          Authorised by:
          */
        @Test
        void testCategoryName(){
            WhatNestCategory cat = new WhatNestCategory("Example");
            assertEquals("Example", cat.getCategoryName());
        }
    }

}