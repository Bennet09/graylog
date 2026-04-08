package com.example.graylog.service;

import com.example.graylog.model.LogEntry;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class LogService {

    private final Map<String, LogEntry> logs = new HashMap<>();

    public LogEntry getLogById(String id) {
        return logs.get(id);
    }

    public LogEntry createLog(String id, String message) {
        LogEntry log = new LogEntry(id, message);
        logs.put(id, log);
        return log;
    }

    public boolean deleteLog(String id) {
        return logs.remove(id) != null;
    }
}