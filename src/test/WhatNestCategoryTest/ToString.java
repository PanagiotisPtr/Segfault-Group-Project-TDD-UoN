package WhatNestCategoryTest;

import WhatNest.WhatNestCategory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("2.12 - WhatNestCategoryTest.ToString")
class ToString {
    /*
     * Checks output when values are all 0
     * Written by: Tara Dilley 28/03/2019
     * Approved by: Panagiotis Petridis
     */
    @Test
    @DisplayName("2.12.1 - Checks output when values are all 0")
    void checkZero() {
        WhatNestCategory cat = new WhatNestCategory("Example");
        BigDecimal num = new BigDecimal("0");
        cat.setCategoryBudget(num);
        cat.addExpense(num);
        assertEquals("[Example] (£0.00) - Est. £0.00 (£0.00 remaining)", cat.toString());
    }
    /*
     * Checks a valid non-zero test case
     * Written by: Tara Dilley 28/03/2019
     * Approved by: Panagiotis Petridis
     */
    @Test
    @DisplayName("2.12.2 - Checks a valid non-zero test case")
    void checkValidCase() {
        WhatNestCategory cat = new WhatNestCategory("Example");
        BigDecimal budget = new BigDecimal("400");
        cat.setCategoryBudget(budget);
        BigDecimal spend = new BigDecimal("200");
        cat.addExpense(spend);
        assertEquals("[Example] (£400.00) - Est. £200.00 (£200.00 remaining)", cat.toString());
    }
    /*
     * Checks that values are correct when user has overspent
     * Written by: Tara Dilley 28/03/2019
     * Approved by: Panagiotis Petridis
     */
    @Test
    @DisplayName("2.12.3 - Checks that values are correct when user has overspent")
    void checkOverspentCase() {
        WhatNestCategory cat = new WhatNestCategory("Example");
        BigDecimal budget = new BigDecimal("400");
        cat.setCategoryBudget(budget);
        BigDecimal spend = new BigDecimal("500");
        cat.addExpense(spend);
        assertEquals("[Example] (£400.00) - Est. £500.00 (£100.00 overspent)", cat.toString());
    }
}

