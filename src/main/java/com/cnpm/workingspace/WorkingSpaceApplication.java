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
	CustomerService service;

	@Override
	public void run(String... args) throws Exception {
		Account account=new Account("trii","142");
		Customer customer=new Customer("tri@gmail.com","tri","123",new Date(),"Vietname","0123123123");
		account.setCustomer(customer);
		int flag=service.insertCustomer(customer);
		System.out.println("flag : "+(flag==0?false:true));
	}
}
