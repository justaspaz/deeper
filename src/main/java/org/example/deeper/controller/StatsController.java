package org.example.deeper.controller;

import org.example.deeper.config.ActiveRequestFilter;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/stats")
public class StatsController {

    @GetMapping("/system-stats")
    public ResponseEntity<String> getActiveRequests() {
        int activeRequests = ActiveRequestFilter.getActiveRequests();
        return ResponseEntity.ok("Total active requests in system: " + activeRequests);
    }
}
