package com.cnpm.workingspace;

import com.cnpm.workingspace.constants.ErrorCode;
import com.cnpm.workingspace.security.response.ErrorResponse;
import com.cnpm.workingspace.utils.PriceUtils;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.LocalDate;
import java.time.YearMonth;

@SpringBootApplication
public class WorkingSpaceApplication implements CommandLineRunner {
    public static void main(String[] args) {
        SpringApplication.run(WorkingSpaceApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        String startDate = "2022-05-30";
        String endDate = "2023-01-30";
        System.out.println(PriceUtils.getDayMonthInterval(startDate,endDate));
    }
}
