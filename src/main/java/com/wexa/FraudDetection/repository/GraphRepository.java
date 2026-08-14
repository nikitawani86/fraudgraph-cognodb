package com.wexa.FraudDetection.repository;

import java.util.List;
import java.util.Map;

import org.neo4j.driver.Driver;
import org.springframework.stereotype.Repository;

@Repository
public class GraphRepository {

    private final Driver driver;

    public GraphRepository(Driver driver) {
        this.driver = driver;
    }

    public List<Map<String, Object>> findCustomerConnections(String customerId) {

        String cypher = """
            MATCH (c:Customer {customerId: $customerId})
                  -[:OWNS]->(a:Account)
                  -[:USES]->(d:Device)
                  <-[:USES]-(connected:Account)
            WHERE a <> connected
            RETURN DISTINCT
                   a.accountId AS sourceAccount,
                   d.deviceId AS sharedDevice,
                   connected.accountId AS connectedAccount
            """;

        try (var session = driver.session()) {
            return session.run(
                    cypher,
                    Map.of("customerId", customerId)
            ).list(record -> Map.of(
                    "sourceAccount", record.get("sourceAccount").asString(),
                    "sharedDevice", record.get("sharedDevice").asString(),
                    "connectedAccount", record.get("connectedAccount").asString()
            ));
        }
    }
    
    
    public List<Map<String, Object>> findCustomerTransactions(String customerId) {

        String cypher = """
            MATCH (c:Customer {customerId: $customerId})
                  -[:OWNS]->(a:Account)
                  -[:MADE]->(t:Transaction)
                  -[:PAID_TO]->(m:Merchant)
            RETURN
                a.accountId AS accountId,
                t.transactionId AS transactionId,
                t.amount AS amount,
                t.status AS status,
                m.name AS merchant
            ORDER BY t.amount DESC
            """;

        try (var session = driver.session()) {
            return session.run(
                    cypher,
                    Map.of("customerId", customerId)
            ).list(record -> Map.of(
                    "accountId", record.get("accountId").asString(),
                    "transactionId", record.get("transactionId").asString(),
                    "amount", record.get("amount").asDouble(),
                    "status", record.get("status").asString(),
                    "merchant", record.get("merchant").asString()
            ));
        }
    }
}