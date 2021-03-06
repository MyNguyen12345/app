package com.cnpm.workingspace.repository;

import com.cnpm.workingspace.model.Account;
import com.cnpm.workingspace.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Integer> {
    Customer findByAccount(Account account);
}
