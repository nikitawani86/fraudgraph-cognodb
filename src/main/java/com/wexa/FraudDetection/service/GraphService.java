package com.wexa.FraudDetection.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.wexa.FraudDetection.repository.GraphRepository;

@Service
public class GraphService {

    private final GraphRepository repository;

    public GraphService(GraphRepository repository) {
        this.repository = repository;
    }

    public List<Map<String, Object>> getConnections(String customerId) {
        return repository.findCustomerConnections(customerId);
    }
    
    
    public List<Map<String, Object>> getTransactions(String customerId) {
        return repository.findCustomerTransactions(customerId);
    }
}

