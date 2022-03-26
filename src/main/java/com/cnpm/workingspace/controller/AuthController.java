package com.cnpm.workingspace.controller;

import com.cnpm.workingspace.payload.request.LoginRequest;
import com.cnpm.workingspace.repository.PersonRepository;
import com.cnpm.workingspace.security.jwt.JwtUtils;
import com.cnpm.workingspace.service.MyUserDetailsService;
import com.cnpm.workingspace.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private MyUserDetailsService myUserDetailsService;

    @Autowired
    private JwtUtils jwtUtils;

    @Autowired
    private PersonService service;
    @PostMapping("/login")
    public ResponseEntity<?> authenticateAccount(@RequestBody LoginRequest loginRequest) throws Exception {
        try{
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(loginRequest.getUsername(),loginRequest.getPassword())
            );
        } catch (BadCredentialsException e){
            throw new Exception("Incorrect username or password",e);
        }
        final UserDetails userDetails = myUserDetailsService.loadUserByUsername(loginRequest.getUsername());
        final String jwt = jwtUtils.generateTokenFromName(userDetails.getUsername());

        return ResponseEntity.ok(jwt);
    }
}
