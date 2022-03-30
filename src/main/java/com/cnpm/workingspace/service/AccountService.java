package com.cnpm.workingspace.service;

import com.cnpm.workingspace.model.Account;
import org.springframework.stereotype.Service;

public interface AccountService {
    boolean existsUsername(String username);
    int insertAccount(Account account);
}
