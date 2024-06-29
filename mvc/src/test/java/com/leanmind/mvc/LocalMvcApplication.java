package com.leanmind.mvc;

import com.leanmind.mvc.configuration.PostgresContainerConfiguration;
import org.springframework.boot.SpringApplication;

public class LocalMvcApplication {

  public static void main(String[] args) {
    SpringApplication.from(MvcApplication::main)
        .with(PostgresContainerConfiguration.class)
        .run(args);
  }
}