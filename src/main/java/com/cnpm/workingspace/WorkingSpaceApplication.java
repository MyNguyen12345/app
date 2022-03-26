package com.cnpm.workingspace;

import com.cnpm.workingspace.security.jwt.JwtUtils;
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

	@Override
	public void run(String... args) throws Exception {
//		String token=jwtUtils.generateTokenFromName("tri");
//		System.out.println("#### TEST TOKEN : "+token);
//		System.out.println("#### NAME FROM TOKEN : "+jwtUtils.getNameFromJwtToken(token));
//		System.out.println("#### Expiration : "+jwtUtils.getExpirationFromJwtToken(token));
//		System.out.println("#### get name  : "+jwtUtils.getNameFromJwtToken("eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJ0cmkiLCJpYXQiOjE2NDgzMDM3MjAsImV4cCI6MTY0ODMwNzMyMH0.y-p5YkqR40wwaZrQdzNIRy9sCFcOAR1BfmLUtC9_PCgvK60oTHpmPbWq2aszbHpimzRSq_JWOvvpIAtWm7GAOQ"));
	}
}
