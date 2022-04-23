package com.cnpm.workingspace;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;

@SpringBootApplication
public class WorkingSpaceApplication implements CommandLineRunner {
    public static void main(String[] args) {
        SpringApplication.run(WorkingSpaceApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

    }
}
