package WhatNestTransactionTest;

import WhatNest.WhatNestTransaction;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@DisplayName("1.07 - WhatNestTransactionTest.SetTransactionName")
class SetTransactionName {
    /*
     * Checks for valid string parameter
     * Written by: Berk Demir 28/03/2019
     * Approved by:
     */
    @Test
    @DisplayName("1.7.1 - Checks for valid string parameter")
    void checkString() {
        WhatNestTransaction n = new WhatNestTransaction();
        n.setTransactionName("hello");
        assertEquals("hello", n.transactionName());
    }
    /*
     * Checks that method will truncate long strings
     * Written by: Berk Demir 28/03/2019
     * Approved by:
     */
    @Test
    @DisplayName("1.7.2 - Checks that method will truncate long strings")
    void checkLength() {
        WhatNestTransaction l = new WhatNestTransaction();
        l.setTransactionName("abcdefghijklmonpqrstuvwxyz");
        assertEquals("abcdefghijklmonpqrstuvwxy", l.transactionName());
    }
    /*
     * Checks that Transaction Name hasn't already been set
     * Written by: Berk Demir 28/03/2019
     * Approved by:
     */
    @Test
    @DisplayName("1.7.3 - Checks that Transaction Name hasn't already been set")
    void checkDuplicate() {
        WhatNestTransaction d = new WhatNestTransaction();
        d.setTransactionName("hello");
        assertThrows(Exception.class, () -> {
            d.setTransactionName("hello");
        });
    }
    /*
     * Checks that reserved name is not used
     * Written by: Berk Demir 28/03/2019
     * Approved by:
     */
    @Test
    @DisplayName("1.7.4 - Checks that reserved name is not used")
    void checkReserve() {
        WhatNestTransaction r = new WhatNestTransaction();
        assertThrows(Exception.class, () -> {
            r.setTransactionName("[Pending Transaction]");
        });
    }
}
