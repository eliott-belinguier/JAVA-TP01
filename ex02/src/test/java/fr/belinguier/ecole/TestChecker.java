package fr.belinguier.ecole;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import static fr.belinguier.ecole.Checker.isCorrectAddress;

public class TestChecker {

    @Test
    public void testCorrectAddress() {
        assertDoesNotThrow(() -> assertTrue(isCorrectAddress("255.255.255.255")));
    }

    @Test
    public void testNullAddress() {
        assertThrowsExactly(Checker.MalformedAddressException.class, () -> isCorrectAddress(null));
    }

    @Test
    public void testTooLongSyntaxAddress() {
        assertThrowsExactly(Checker.MalformedAddressException.class, () -> isCorrectAddress("255.255.255.255.255"));
    }

    @Test
    public void testByteOverflowAddress() {
        assertThrowsExactly(Checker.MalformedAddressException.class, () -> isCorrectAddress("255.255.256.255"));
    }

    @Test
    public void testSyntaxAddress() {
        assertThrowsExactly(Checker.MalformedAddressException.class, () -> isCorrectAddress("255.25A.255.255"));
    }


}
