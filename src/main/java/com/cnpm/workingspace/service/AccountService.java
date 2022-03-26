package com.cnpm.workingspace.service;

import org.springframework.stereotype.Service;

@Service
public interface AccountService {
    boolean existsByUsername(String username);
}
