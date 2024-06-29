package com.leanmind.mvc;

import org.springframework.boot.SpringApplication;

public class TestMvcApplication {

    public static void main(String[] args) {
        SpringApplication.from(MvcApplication::main).with(TestcontainersConfiguration.class).run(args);
    }

}
