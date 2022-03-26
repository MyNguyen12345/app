package com.cnpm.workingspace.security.filter;

import com.cnpm.workingspace.security.jwt.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static java.util.Collections.emptyList;

public class CustomAuthorizationFilter extends OncePerRequestFilter {

    private JwtUtils jwtUtils;

    public CustomAuthorizationFilter(JwtUtils jwtUtils) {
        this.jwtUtils = jwtUtils;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        if(request.getServletPath().equals("/api/auth/login")){
            System.out.println("path : "+request.getServletPath());
            filterChain.doFilter(request,response);
        } else{
            System.out.println("path : "+request.getServletPath());
        }
        SecurityContextHolder.getContext().setAuthentication(null);
        String authorizationHeader=request.getHeader("Authorization");
        if(authorizationHeader!=null){
            String token=authorizationHeader;
            System.out.println("get token from request : "+token);
            String username=jwtUtils.getNameFromJwtToken(token);
            System.out.println("filter get name : "+username);
            UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken=
                    new UsernamePasswordAuthenticationToken(username,null,emptyList());
            SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
            System.out.println("Success !!!");
            filterChain.doFilter(request,response);
        } else{
            System.out.println("dont have authorizationHeader");
        }
        filterChain.doFilter(request,response);

    }
}
