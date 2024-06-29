package com.leanmind.mvc.configuration;

import com.github.dockerjava.api.model.ExposedPort;
import com.github.dockerjava.api.model.HostConfig;
import com.github.dockerjava.api.model.PortBinding;
import com.github.dockerjava.api.model.Ports.Binding;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.springframework.context.annotation.Bean;
import org.testcontainers.containers.PostgreSQLContainer;

@TestConfiguration(proxyBeanMethods = false)
public class PostgresContainerConfiguration {

  @Bean
  @ServiceConnection
  public PostgreSQLContainer<?> postgreSQLContainer() {
    return new PostgreSQLContainer<>("postgres:13.2")
        .withExposedPorts(5432)
        .withCreateContainerCmdModifier(cmd -> cmd.withHostConfig(
            new HostConfig()
                .withPortBindings(new PortBinding(Binding.bindPort(5432),new ExposedPort(5432))
                )
            )
        )
        .withDatabaseName("test_mvc")
        .withUsername("user")
        .withPassword("password")
        .withInitScript("init.sql");
  }
}