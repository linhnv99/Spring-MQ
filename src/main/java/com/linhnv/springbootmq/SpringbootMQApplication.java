package com.linhnv.springbootmq;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringbootMQApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootMQApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
    }
}
