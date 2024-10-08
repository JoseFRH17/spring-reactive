package com.leanmind.reactivemvc.configuration;

import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.springframework.context.annotation.Bean;
import org.testcontainers.containers.PostgreSQLContainer;

@TestConfiguration(proxyBeanMethods = false)
public class ReactivePostgresContainer {
  @Bean
  @ServiceConnection
  @SuppressWarnings("resource")
  public PostgreSQLContainer<?> postgreSQLContainer() {
    return new PostgreSQLContainer<>("postgres:13.2")
        .withDatabaseName("reactive_general_market")
        .withUsername("user")
        .withPassword("password")
        .withInitScript("init.sql");
  }
}
