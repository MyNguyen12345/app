package com.cnpm.workingspace.service;

import com.cnpm.workingspace.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class AccountServiceImp implements AccountService{

    @Autowired
    AccountRepository accountRepository;

    @Override
    public boolean existsByUsername(String username) {
        // todo : implement
        return false;
    }
}
