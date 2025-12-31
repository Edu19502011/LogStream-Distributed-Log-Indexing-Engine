package com.logstream.model;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;

/**
 * Represents a single log entry in the system.
 */
public class LogEntry {
    private String id;
    private Date timestamp;
    private String service;
    private LogLevel level;
    private String message;
    private Map<String, String> metadata;

    public LogEntry() {
        this.id = UUID.randomUUID().toString();
        this.timestamp = new Date();
        this.metadata = new HashMap<>();
    }

    public LogEntry(String id, Date timestamp, String service, LogLevel level, String message) {
        this.id = id;
        this.timestamp = timestamp;
        this.service = service;
        this.level = level;
        this.message = message;
        this.metadata = new HashMap<>();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public LogLevel getLevel() {
        return level;
    }

    public void setLevel(LogLevel level) {
        this.level = level;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Map<String, String> getMetadata() {
        return metadata;
    }

    public void setMetadata(Map<String, String> metadata) {
        this.metadata = metadata != null ? metadata : new HashMap<>();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LogEntry logEntry = (LogEntry) o;
        return Objects.equals(id, logEntry.id) &&
               Objects.equals(timestamp, logEntry.timestamp) &&
               Objects.equals(service, logEntry.service) &&
               level == logEntry.level &&
               Objects.equals(message, logEntry.message) &&
               Objects.equals(metadata, logEntry.metadata);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, timestamp, service, level, message, metadata);
    }

    @Override
    public String toString() {
        return "LogEntry{" +
               "id='" + id + '\'' +
               ", timestamp=" + timestamp +
               ", service='" + service + '\'' +
               ", level=" + level +
               ", message='" + message + '\'' +
               ", metadata=" + metadata +
               '}';
    }
}
