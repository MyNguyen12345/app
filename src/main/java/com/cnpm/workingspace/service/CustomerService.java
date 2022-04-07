package com.cnpm.workingspace.service;

import java.util.List;

import com.cnpm.workingspace.model.Account;
import com.cnpm.workingspace.model.Customer;

public interface CustomerService {
    int insertCustomer(Customer customer);
    
    List<Customer> getAll();
}
