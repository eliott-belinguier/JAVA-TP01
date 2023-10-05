package fr.belinguier.ecole;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import static fr.belinguier.ecole.Converter.*;

public class TestConverter {

    @Test
    public void testConvertHoursToSeconds() {
        assertEquals(3600, convertToSecond(1, 0,  0));
    }

    @Test
    public void testConvertMinutesToSeconds() {
        assertEquals(60, convertToSecond(0, 1,  0));
    }

    @Test
    public void testConvertSecondsToSeconds() {
        assertEquals(10, convertToSecond(0, 0,  10));
    }

    @Test
    public void testConvertAllToSeconds() {
        assertEquals(3725, convertToSecond(1, 2,  5));
    }

    @Test
    public void testConvertSecondsToTimeHours() {
        assertEquals("01:00:00", convertSecondToTime(3600));
    }

    @Test
    public void testConvertSecondsToTimeMinutes() {
        assertEquals("00:01:00", convertSecondToTime(60));
    }

    @Test
    public void testConvertSecondsToTimeSeconds() {
        assertEquals("00:00:10", convertSecondToTime(10));
    }

    @Test
    public void testConvertSecondsToTimeAll() {
        assertEquals("01:02:05", convertSecondToTime(3725));
    }

}
