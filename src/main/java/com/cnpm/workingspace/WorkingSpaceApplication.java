package com.cnpm.workingspace;

import com.cnpm.workingspace.security.jwt.JwtUtils;
import com.cnpm.workingspace.service.AccountService;
import com.cnpm.workingspace.service.CustomerService;
import com.cnpm.workingspace.service.PriceService;
import com.cnpm.workingspace.service.PropertyService;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import com.cnpm.workingspace.service.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;

@SpringBootApplication
public class WorkingSpaceApplication implements CommandLineRunner {

    @Autowired
    JwtUtils jwtUtils;

    @Bean
    @Scope("prototype")
    public ModelMapper getModelMapper() {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        return modelMapper;
    }

	@Autowired
	AccountService accountService;

    public static void main(String[] args) {
        SpringApplication.run(WorkingSpaceApplication.class, args);
    }

	@Autowired
	ReservationStatusService reservationStatusService;

	@Override
	public void run(String... args) throws Exception {
	}
}
