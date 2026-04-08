package com.example.graylog.controller;

import com.example.graylog.model.LogEntry;
import com.example.graylog.service.LogService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/logs")
public class LogController {

    private final LogService logService;

    public LogController(LogService logService) {
        this.logService = logService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<LogEntry> getLog(@PathVariable String id) {
        LogEntry log = logService.getLogById(id);
        if (log == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(log);
    }

    @PostMapping("/{id}")
    public ResponseEntity<LogEntry> createLog(@PathVariable String id, @RequestBody String message) {
        LogEntry log = logService.createLog(id, message);
        return ResponseEntity.ok(log);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLog(@PathVariable String id) {
        boolean deleted = logService.deleteLog(id);
        if (!deleted) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().build();
    }
}