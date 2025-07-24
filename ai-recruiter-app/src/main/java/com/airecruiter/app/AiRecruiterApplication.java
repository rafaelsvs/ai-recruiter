package com.airecruiter.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication(scanBasePackages = "com.airecruiter")
@EnableJpaRepositories(basePackages = "com.airecruiter.data.repository")
@EntityScan(basePackages = "com.airecruiter.data.entity")
public class AiRecruiterApplication {
    public static void main(String[] args) {
        SpringApplication.run(AiRecruiterApplication.class, args);
    }
}