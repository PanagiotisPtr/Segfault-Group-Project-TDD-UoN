import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WhatNestCategoryTest {
    @Nested
    class CategoryName{
        /* Create Category object with name "Example" and make sure it returns 
         * the correct category name
         * Written by: Lars Lunde
         * Date: 25/03/2019
         * Authorised by: Matthew Smith
         */
        @Test
        void testCategoryName(){
            WhatNestCategory cat = new WhatNestCategory("Example");
            assertEquals("Example", cat.getCategoryName());
        }
    }

}