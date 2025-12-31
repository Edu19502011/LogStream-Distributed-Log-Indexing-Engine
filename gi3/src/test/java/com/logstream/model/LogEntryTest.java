package com.logstream.model;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class LogEntryTest {

    private final Gson gson = new GsonBuilder()
            .setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
            .create();

    @Test
    void testLogEntryCreation() {
        LogEntry entry = new LogEntry();
        assertNotNull(entry.getId());
        assertNotNull(entry.getTimestamp());
        assertNotNull(entry.getMetadata());
    }

    @Test
    void testLogEntryWithParameters() {
        String id = "test-123";
        Date timestamp = new Date();
        String service = "auth-service";
        LogLevel level = LogLevel.ERROR;
        String message = "Authentication failed";

        LogEntry entry = new LogEntry(id, timestamp, service, level, message);

        assertEquals(id, entry.getId());
        assertEquals(timestamp, entry.getTimestamp());
        assertEquals(service, entry.getService());
        assertEquals(level, entry.getLevel());
        assertEquals(message, entry.getMessage());
        assertNotNull(entry.getMetadata());
    }

    @Test
    void testLogEntrySerialization() {
        LogEntry entry = new LogEntry();
        entry.setService("test-service");
        entry.setLevel(LogLevel.INFO);
        entry.setMessage("Test message");
        
        Map<String, String> metadata = new HashMap<>();
        metadata.put("key1", "value1");
        entry.setMetadata(metadata);

        String json = gson.toJson(entry);
        assertNotNull(json);
        assertTrue(json.contains("test-service"));
        assertTrue(json.contains("INFO"));
        assertTrue(json.contains("Test message"));
    }

    @Test
    void testLogEntryDeserialization() {
        String json = "{\"id\":\"test-123\",\"timestamp\":\"2024-01-01T00:00:00.000Z\"," +
                      "\"service\":\"test-service\",\"level\":\"ERROR\"," +
                      "\"message\":\"Test error\",\"metadata\":{\"key\":\"value\"}}";

        LogEntry entry = gson.fromJson(json, LogEntry.class);

        assertEquals("test-123", entry.getId());
        assertEquals("test-service", entry.getService());
        assertEquals(LogLevel.ERROR, entry.getLevel());
        assertEquals("Test error", entry.getMessage());
        assertEquals("value", entry.getMetadata().get("key"));
    }

    @Test
    void testLogEntryEquality() {
        Date timestamp = new Date();
        LogEntry entry1 = new LogEntry("id1", timestamp, "service", LogLevel.INFO, "message");
        LogEntry entry2 = new LogEntry("id1", timestamp, "service", LogLevel.INFO, "message");
        LogEntry entry3 = new LogEntry("id2", timestamp, "service", LogLevel.INFO, "message");

        assertEquals(entry1, entry2);
        assertNotEquals(entry1, entry3);
    }

    @Test
    void testMetadataHandling() {
        LogEntry entry = new LogEntry();
        entry.setMetadata(null);
        assertNotNull(entry.getMetadata());
        assertTrue(entry.getMetadata().isEmpty());
    }
}
