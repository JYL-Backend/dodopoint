package com.example.dodopoint;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class DodopointApplication {

    public static void main(String[] args) {
        SpringApplication.run(DodopointApplication.class, args);
    }

}
