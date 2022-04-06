package com.cnpm.workingspace.dto;

import com.cnpm.workingspace.model.Account;
import com.cnpm.workingspace.model.Customer;
import lombok.Data;

@Data
public class CustomerAccount {
    private String username;
    private String password;
    private String email;
    private String customerName;
    private String phoneNumber;

    public Account getAccount() {
        return new Account(username, password);
    }

    public Customer getCustomer() {
        return new Customer(email, customerName, phoneNumber);
    }
}
