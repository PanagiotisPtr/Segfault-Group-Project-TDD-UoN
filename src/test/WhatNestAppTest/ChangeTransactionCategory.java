package WhatNestAppTest;

import WhatNest.*;
import org.junit.jupiter.api.*;
import java.io.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("3.05 - WhatNestAppTest.ChangeTransactionCategory")
class ChangeTransactionCategory {
    private static ByteArrayOutputStream output;

    @BeforeAll
    static void init() {
        output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));
    }

    @BeforeEach
    void clearOut() {
        output.reset();
        WhatNestApp.UserCategories = new ArrayList<WhatNestCategory>();
        WhatNestApp.UserTransactions = new ArrayList<WhatNestTransaction>();
    }

    @AfterAll
    static void disp() {
        System.setOut(System.out);
        System.setIn(System.in);
    }

    /* 3.5.1 - Test with valid category ID
     * Written by: Berk Demir 02/04/19
     * Authorised by:
     */
    @Test
    @DisplayName("3.5.1 - Test with valid category ID")
    void testValid() {
    }

    /* 3.5.2 - Test again with multiple transactions in category
     * Written by: Berk Demir 02/04/19
     * Authorised by:
     */
    @Test
    @DisplayName("3.5.2 - Test again with multiple transactions in category")
    void testMultipleTransactions() {

    }

    /* 3.5.3 - Test changing to same category
     * Written by: Berk Demir 02/04/19
     * Authorised by:
     */
    @Test
    @DisplayName("3.5.3 - Test changing to same category")
    void testSameCat() {

    }

    /* 3.5.4 - Test with 3 categories and multiple transactions
     * Written by: Berk Demir 02/04/19
     * Authorised by:
     */
    @Test
    @DisplayName("3.5.4 - Test with 3 categories and multiple transactions")
    void testMulCatMulTrans() {

    }

    /* 3.5.5 - Test with invalid input - 2x non-number on first input
     * Written by: Berk Demir 02/04/19
     * Authorised by:
     */
    @Test
    @DisplayName("3.5.5 - Test with invalid input - 2x non-number on first input")
    void testFirstInvalid() {

    }

    /* 3.5.6 - Test with invalid input - negative number on first input
     * Written by: Berk Demir 02/04/19
     * Authorised by:
     */
    @Test
    @DisplayName("3.5.6 - Test with invalid input - negative number on first input")
    void testFirstNegative() {

    }

    /* 3.5.7 - Test with invalid input - above bounds number on first input
     * Written by: Berk Demir 02/04/19
     * Authorised by:
     */
    @Test
    @DisplayName("3.5.6 - Test with invalid input - above bounds number on first input")
    void testFirstAboveBounds() {

    }

    /* 3.5.8 - Test with invalid input - in bounds decimal number on first input
     * Written by: Berk Demir 02/04/19
     * Authorised by:
     */
    @Test
    @DisplayName("3.5.8 - Test with invalid input - in bounds decimal number on first input")
    void testFirstDecimal() {

    }

    /* 3.5.9 - Test with invalid input - 2x non-number on second input
     * Written by: Berk Demir 02/04/19
     * Authorised by:
     */
    @Test
    @DisplayName("3.5.6 - Test with invalid input - 2x non-number on second input")
    void testSecondInvalid() {

    }

    /* 3.5.10 - Test with invalid input - negative number on second input
     * Written by: Berk Demir 02/04/19
     * Authorised by:
     */
    @Test
    @DisplayName("3.5.10 - Test with invalid input - negative number on second input")
    void testSecondNegative() {

    }

    /* 3.5.11 - Test with invalid input - above bounds number on second input
     * Written by: Berk Demir 02/04/19
     * Authorised by:
     */
    @Test
    @DisplayName("3.5.11 - Test with invalid input - above bounds number on second input")
    void testSecondAboveBounds() {

    }

    /* 3.5.12 - Test with invalid input - in bounds decimal number on second input
     * Written by: Berk Demir 02/04/19
     * Authorised by:
     */
    @Test
    @DisplayName("3.5.6 - Test with invalid input - in bounds deciaml number on second input")
    void testSecondDecimal() {

    }
}