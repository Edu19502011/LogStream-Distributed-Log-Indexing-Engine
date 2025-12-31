package com.logstream.model;

/**
 * Enumeration of log severity levels.
 */
public enum LogLevel {
    DEBUG(0),
    INFO(1),
    WARN(2),
    ERROR(3);

    private final int code;

    LogLevel(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public static LogLevel fromCode(int code) {
        for (LogLevel level : values()) {
            if (level.code == code) {
                return level;
            }
        }
        throw new IllegalArgumentException("Invalid log level code: " + code);
    }

    public static LogLevel fromString(String level) {
        try {
            return valueOf(level.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Invalid log level: " + level);
        }
    }
}
