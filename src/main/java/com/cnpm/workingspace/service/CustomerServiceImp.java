package com.cnpm.workingspace.service;

import com.cnpm.workingspace.model.Account;
import com.cnpm.workingspace.model.Customer;
import com.cnpm.workingspace.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImp implements CustomerService{

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public int insertCustomer(Customer customer) {
        try{
            Customer ret=customerRepository.save(customer);
            if(ret==null) return 0;
        } catch (Exception e){
            System.out.println("Debug insert : "+e.getMessage());
            e.printStackTrace();
            return 0;
        }
        return 1;
    }
}
