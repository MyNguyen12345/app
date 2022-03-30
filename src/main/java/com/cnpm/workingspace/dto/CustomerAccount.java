package com.cnpm.workingspace.dto;

import com.cnpm.workingspace.model.Account;
import com.cnpm.workingspace.model.Customer;

public class CustomerAccount {
    private Account account;
    private Customer customer;

    public CustomerAccount(Account account, Customer customer) {
        this.account = account;
        this.customer = customer;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
