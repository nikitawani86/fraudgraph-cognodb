package com.wexa.FraudDetection.config;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

import org.neo4j.driver.Driver;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class SeedDataRunner implements CommandLineRunner {

    private final Driver driver;

    public SeedDataRunner(Driver driver) {
        this.driver = driver;
    }

    @Override
    public void run(String... args) throws Exception {

        Path path = Path.of("data/seed.cypher");

        if (!Files.exists(path)) {
            System.out.println("Seed file not found: " + path);
            return;
        }

        String content = Files.readString(path);

        String[] statements = content.split(";");

        try (var session = driver.session()) {

            Arrays.stream(statements)
                    .map(String::trim)
                    .filter(statement -> !statement.isEmpty())
                    .forEach(statement -> {
                        session.run(statement).consume();
                    });
        }

        System.out.println("=================================");
        System.out.println("Seed data loaded successfully!");
        System.out.println("=================================");
    }
}