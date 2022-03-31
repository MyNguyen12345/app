package com.cnpm.workingspace.security;

import com.cnpm.workingspace.security.filter.CustomAuthenticationFilter;
import com.cnpm.workingspace.security.filter.CustomAuthorizationFilter;
import com.cnpm.workingspace.security.jwt.JwtUtils;
import com.cnpm.workingspace.service.MyUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.HttpStatusEntryPoint;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    DataSource dataSource;

    @Autowired
    MyUserDetailsService myUserDetailsService;

    @Autowired
    JwtUtils jwtUtils;

    @Override
    protected void configure(HttpSecurity security) throws Exception {
        security.csrf().disable()
                .authorizeRequests()
                .antMatchers(HttpMethod.PUT,"/api/price/pricee/*").permitAll()
                .antMatchers("/").permitAll();
//        security.csrf().disable()
//                .authorizeRequests().antMatchers("/api/auth/*").permitAll()
//                .antMatchers("/api/price/**").permitAll()
////                .antMatchers("/api/price/{id}/**").permitAll()
//                .anyRequest().authenticated();
//        security
//                .exceptionHandling()
//                .authenticationEntryPoint((request, response, e) -> {
//                    response.setStatus(HttpStatus.UNAUTHORIZED.value());
//                    response.setContentType("application/json");
//                    response.getWriter().write("{ \"error\": \"You are not authenticated.\" }");
//                });
        security.addFilter(new CustomAuthenticationFilter(authenticationManager()));
        security.addFilterBefore(new CustomAuthorizationFilter(jwtUtils),UsernamePasswordAuthenticationFilter.class);
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.inMemoryAuthentication().withUser("admin").password("{noop}password").roles("ADMIN");
        auth.userDetailsService(myUserDetailsService);

    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return NoOpPasswordEncoder.getInstance();
    }

    @Override
    @Bean
    public AuthenticationManager authenticationManager() throws Exception {
        return super.authenticationManager();
    }
}
