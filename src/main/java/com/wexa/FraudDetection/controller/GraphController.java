package com.wexa.FraudDetection.controller;

import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.*;

import com.wexa.FraudDetection.service.GraphService;

@RestController
@RequestMapping("/api/customers")
@CrossOrigin(origins = "*")
public class GraphController {

    private final GraphService service;

    public GraphController(GraphService service) {
        this.service = service;
    }

    @GetMapping("/{customerId}/connections")
    public List<Map<String, Object>> getConnections(
            @PathVariable String customerId) {

        return service.getConnections(customerId);
    }
    
    @GetMapping("/{customerId}/transactions")
    public List<Map<String, Object>> getTransactions(
            @PathVariable String customerId) {

        return service.getTransactions(customerId);
    }
}