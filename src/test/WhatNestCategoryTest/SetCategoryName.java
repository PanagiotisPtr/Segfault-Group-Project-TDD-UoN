package WhatNestCategoryTest;

import WhatNest.WhatNestApp;
import WhatNest.WhatNestCategory;
import WhatNest.WhatNestTransaction;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@DisplayName("2.04 - WhatNestCategoryTest.SetCategoryName")
class SetCategoryName {

    @BeforeEach
    void initialise() {
        WhatNestApp.UserCategories = new ArrayList<>();
    }
    /*
     * Make sure that the name changes when you call function with a string
     * Written by: Lars Lunde 28/03/2019
     * Approved by: Panagiotis Petridis
     */
    @Test
    @DisplayName("2.4.1 - Make sure that the name changes when you call function with a string")
    void baseCase() {
        WhatNestCategory cat = new WhatNestCategory("Example");
        cat.setCategoryName("AnotherName");
        assertEquals("AnotherName", cat.CategoryName());
    }
    /*
     * Check that it handles long names
     * Written by: Lars Lunde 28/03/2019
     * Approved by: Panagiotis Petridis
     */
    @Test
    @DisplayName("2.4.2 - Check that it handles long names")
    void longName() {
        WhatNestCategory cat = new WhatNestCategory("Example");
        assertThrows(Exception.class, () -> {
            cat.setCategoryName("AVeryVeryLongLongName");        
        });
    }
    /*
     * Check that it handles empty names
     * Written by: Lars Lunde 28/03/2019
     * Approved by: Panagiotis Petridis
     */
    @Test
    @DisplayName("2.4.3 - Check that it handles empty names")
    void emptyName() {
        WhatNestCategory cat = new WhatNestCategory("Example");
        assertThrows(Exception.class, () -> {
            cat.setCategoryName("");
        });
    }
    /*
     * Create 2 classes with same name make sure it gives error
     * Written by: Lars Lunde 28/03/2019
     * Approved by: Panagiotis Petridis
     */
    @Test
    @DisplayName("2.4.4 - Create 2 classes with same name make sure it gives error")
    void duplicateCategory() {
        WhatNestCategory cat = new WhatNestCategory("Example");
        WhatNestApp.UserCategories.add(cat);
        assertThrows(Exception.class, () -> {
            WhatNestCategory dog = new WhatNestCategory("Example");
            WhatNestApp.UserCategories.add(dog);
        });
    }
    /*
     * Make sure that class has spend and budget to 0 and not an arbitrary
     * value
     * Written by: Lars Lunde 28/03/2019
     * Approved by: Panagiotis Petridis
     */
    @Test
    @DisplayName("2.4.5 - value")
    void testDefaults() {
        WhatNestCategory cat = new WhatNestCategory("Example");
        BigDecimal tmp = new BigDecimal("0.00");
        assertEquals(0, cat.CategorySpend().compareTo(tmp));
        assertEquals(0, cat.CategoryBudget().compareTo(tmp));
    }
    /*
     * Check Unicode characters
     * Using Constructor
     * Written by: Lars Lunde 28/03/2019
     * Approved by: Panagiotis Petridis
     */
    @Test
    @DisplayName("2.4.6 - Using Constructor")
    void testUnicodeName() {
        WhatNestCategory cat = new WhatNestCategory("Example");
        cat.setCategoryName("σφαλμα");
        assertEquals("σφαλμα", cat.CategoryName());
    }
}
