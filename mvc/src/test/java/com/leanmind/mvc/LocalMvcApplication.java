package com.leanmind.mvc;

import com.leanmind.mvc.configuration.PostgresContainerConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LocalMvcApplication {

    public static void main(String[] args) {
        SpringApplication.from(LocalMvcApplication::main)
                .with(PostgresContainerConfiguration.class)
                .run(args);
    }
}
