package com.logstream.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class LogLevelTest {

    @Test
    void testFromCode() {
        assertEquals(LogLevel.DEBUG, LogLevel.fromCode(0));
        assertEquals(LogLevel.INFO, LogLevel.fromCode(1));
        assertEquals(LogLevel.WARN, LogLevel.fromCode(2));
        assertEquals(LogLevel.ERROR, LogLevel.fromCode(3));
    }

    @Test
    void testFromCodeInvalid() {
        assertThrows(IllegalArgumentException.class, () -> LogLevel.fromCode(99));
    }

    @Test
    void testFromString() {
        assertEquals(LogLevel.DEBUG, LogLevel.fromString("debug"));
        assertEquals(LogLevel.INFO, LogLevel.fromString("INFO"));
        assertEquals(LogLevel.WARN, LogLevel.fromString("Warn"));
        assertEquals(LogLevel.ERROR, LogLevel.fromString("ERROR"));
    }

    @Test
    void testFromStringInvalid() {
        assertThrows(IllegalArgumentException.class, () -> LogLevel.fromString("INVALID"));
    }

    @Test
    void testGetCode() {
        assertEquals(0, LogLevel.DEBUG.getCode());
        assertEquals(1, LogLevel.INFO.getCode());
        assertEquals(2, LogLevel.WARN.getCode());
        assertEquals(3, LogLevel.ERROR.getCode());
    }
}
