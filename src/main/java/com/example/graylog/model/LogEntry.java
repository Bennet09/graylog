package com.example.graylog.model;

public class LogEntry {
    private String id;
    private String message;

    public LogEntry() {}

    public LogEntry(String id, String message) {
        this.id = id;
        this.message = message;
    }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }
}