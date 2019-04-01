package WhatNestCategoryTest;

import WhatNest.WhatNestCategory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("2.01 - WhatNestCategoryTest.CategoryName")
class CategoryName{
    /* Create Category object with name "Example" and make sure it returns 
     * the correct category name
     * Written by: Lars Lunde
     * Date: 25/03/2019
     * Authorised by: Matthew Smith
     */
    @Test
    @DisplayName("2.1.1 - the correct category name")
    void testCategoryName(){
        WhatNestCategory cat = new WhatNestCategory("Example");
        assertEquals("Example", cat.CategoryName());
    }
}
