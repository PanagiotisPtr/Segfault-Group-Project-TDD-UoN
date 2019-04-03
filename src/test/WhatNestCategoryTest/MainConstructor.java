package WhatNestCategoryTest;

import WhatNest.WhatNestApp;
import WhatNest.WhatNestCategory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@DisplayName("2.07 - WhatNestCategoryTest.MainConstructor")
class MainConstructor {
    @BeforeEach
    void initialise() {
        WhatNestApp.UserCategories = new ArrayList<>();
    }

    /*
     * Check that it meets specification
     * Written by: Berk Demir 28/03/2019
     * Approved by: Panagiotis Petridis
     */
    @Test
    @DisplayName("2.7.1 - Check that it meets specification")
    void checkCreate() {
        WhatNestCategory cat = new WhatNestCategory("Example");
        assertEquals("Example", cat.CategoryName());
    }
    /*
     * Create 2 classes with same name make sure it gives error
     * Written by: Berk Demir 28/03/2019
     * Approved by: Panagiotis Petridis
     */
    @Test
    @DisplayName("2.7.2 - Create 2 classes with same name make sure it gives error")
    void checkDuplicate() {
        WhatNestCategory dup = new WhatNestCategory("Example");
        WhatNestApp.UserCategories.add(dup);
        assertThrows(Exception.class, () -> {
            WhatNestCategory dup2 = new WhatNestCategory("Example");
            WhatNestApp.UserCategories.add(dup2);
        });
    }
    /*
     * Make sure that class has spend and budget to 0 and not an arbitrary value
     * Written by: Berk Demir 28/03/2019
     * Approved by: Panagiotis Petridis
     */
    @Test
    @DisplayName("2.7.3 - Make sure that class has spend and budget to 0 and not an arbitrary value")
    void checkZeros() {
        WhatNestCategory def = new WhatNestCategory("Example");
        BigDecimal zero = new BigDecimal(0);
        assertEquals(0, def.CategorySpend().compareTo(zero));
        assertEquals(0, def.CategoryBudget().compareTo(zero));
    }
    /*
     * Check Unicode characters
     * Written by: Berk Demir 28/03/2019
     * Approved by: Panagiotis Petridis
     */
    @Test
    @DisplayName("2.7.4 - Check Unicode characters")
    void checkUnicode() {
        WhatNestCategory uni = new WhatNestCategory("σφαλμα");
        assertEquals("σφαλμα", uni.CategoryName());
    }
    /*
     * Check that default constructor handles long names
     * Written by: Berk Demir 28/03/2019
     * Approved by: Panagiotis Petridis
     */
    @Test
    @DisplayName("2.7.5 - Check that default constructor handles long names")
    void checkLongName() {
        assertThrows(Exception.class, () -> {
            WhatNestCategory lng = new WhatNestCategory("AVeryVeryVeryLongLongLongName");
        });
    }
    /*
     * Check that it handles empty names
     * Written by: Berk Demir 28/03/2019
     * Approved by: Panagiotis Petridis
     */
    @Test
    @DisplayName("2.7.6 - Check that it handles empty names")
    void checkBlank() {
        assertThrows(Exception.class, () -> {
            WhatNestCategory blank = new WhatNestCategory("");
        });
    }
}
