package org.example.util;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IdValidityCheckerTest
{
    @Test
    void checkDoBValidity()
    {
        IdValidityChecker checker = new IdValidityChecker();
        assertTrue(checker.checkDoBValidity("520727", "3")); //example from your docs
        assertTrue(checker.checkDoBValidity("791125", "5")); //from Croatian wiki page
    }
}