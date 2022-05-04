package com.cnpm.workingspace.service;

import com.cnpm.workingspace.model.Account;
import com.cnpm.workingspace.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImp implements AccountService{

    @Autowired
    AccountRepository accountRepository;

    @Override
    public boolean existsUsername(String username) {
        try{
            Account account=accountRepository.findByUsername(username);
            System.out.println("# account : "+account);
            return account!=null;
        } catch (Exception e){
            System.out.println("error : "+e.getMessage());
            return false;
        }
    }

    @Override
    public int insertAccount(Account account) {
        try{
            Account ret=accountRepository.save(account);
            if(ret==null) return 0;
        } catch (Exception e){
            System.out.println("Debug insert : "+e.getMessage());
            e.printStackTrace();
            return 0;
        }
        return 1;
    }

    @Override
    public Account findAccountByUsername(String username) {
        return accountRepository.findByUsername(username);
    }
}
