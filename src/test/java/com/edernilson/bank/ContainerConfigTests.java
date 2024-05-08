package com.edernilson.bank;

import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;

/**
 * @author: github.com/edernilson
 * @user: eder.nilson
 * @created: 08/05/2024, quarta-feira
 */
public class ContainerConfigTests {
    @Container
    @ServiceConnection
    static PostgreSQLContainer<?> postgres = new PostgreSQLContainer<>(
            "postgres:latest"
    );
}