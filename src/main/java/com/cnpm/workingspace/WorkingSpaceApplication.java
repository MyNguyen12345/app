package com.cnpm.workingspace;

import com.cnpm.workingspace.model.Account;
import com.cnpm.workingspace.model.Customer;
import com.cnpm.workingspace.security.jwt.JwtUtils;
import com.cnpm.workingspace.service.AccountService;
import com.cnpm.workingspace.service.AccountServiceImp;
import com.cnpm.workingspace.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

@SpringBootApplication
public class WorkingSpaceApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(WorkingSpaceApplication.class, args);
	}

	@Autowired
	JwtUtils jwtUtils;

	@Autowired
	CustomerService customerService;

	@Autowired
	AccountService accountService;

	@Override
	public void run(String... args) throws Exception {
		System.out.println("check exist : "+accountService.existsUsername("trii"));
	}
}
