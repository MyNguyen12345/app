package com.cnpm.workingspace.service;

import java.util.List;
import java.util.Optional;

import com.cnpm.workingspace.model.Account;
import com.cnpm.workingspace.model.Customer;
import com.cnpm.workingspace.model.Person;

public interface CustomerService {
    int insertCustomer(Customer customer);
    List<Customer> getAll();
    Optional<Customer> getCustomerById(int id);
    Customer getCustomerByUserName(Account account);
    boolean updateCustomer(Customer customer, int id);
    void deleteCustomer(int id);
}
