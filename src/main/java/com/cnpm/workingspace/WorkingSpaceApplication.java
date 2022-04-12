package com.cnpm.workingspace;

import com.cnpm.workingspace.security.jwt.JwtUtils;
import com.cnpm.workingspace.service.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WorkingSpaceApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(WorkingSpaceApplication.class, args);
	}

	@Autowired
	JwtUtils jwtUtils;

	@Autowired
	CustomerService customerService;

<<<<<<< Updated upstream
	@Autowired
	AccountService accountService;
	
	@Autowired
	PriceService priceService;
	
	@Autowired
	PropertyService propertyService;
=======
    public static void main(String[] args) {
        SpringApplication.run(WorkingSpaceApplication.class, args);
    }
>>>>>>> Stashed changes

	@Autowired
	ReservationStatusService reservationStatusService;

	@Override
	public void run(String... args) throws Exception {
		System.out.println("check exist : "+accountService.existsUsername("trii"));
	}
}
