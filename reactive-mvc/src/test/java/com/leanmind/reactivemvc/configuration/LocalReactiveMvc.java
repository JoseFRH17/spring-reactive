package com.leanmind.reactivemvc.configuration;


import com.leanmind.reactivemvc.ReactiveMvcApplication;
import org.springframework.boot.SpringApplication;

public class LocalReactiveMvc {
    public static void main(String[] args) {
        SpringApplication.from(ReactiveMvcApplication::main)
                .with(ReactivePostgresContainer.class)
                .run(args);
    }
}
