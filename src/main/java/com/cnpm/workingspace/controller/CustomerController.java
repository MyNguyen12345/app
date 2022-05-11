package com.cnpm.workingspace.controller;

import com.cnpm.workingspace.constants.ErrorCode;
import com.cnpm.workingspace.model.Customer;
import com.cnpm.workingspace.security.response.ErrorResponse;
import com.cnpm.workingspace.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/customer")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

   @GetMapping()
    public ResponseEntity<?> getAll(){
       List<Customer> customers=customerService.getAll();
       return new ResponseEntity<>(new ErrorResponse(ErrorCode.SUCCESS,customers),HttpStatus.OK);
   }
   @GetMapping("/{customerId}")
    public ResponseEntity<?> getCustomerById(@PathVariable int customerId){
       Optional<Customer> customer=customerService.getCustomerById(customerId);
       if (customer.isPresent()){
           Customer customer1=customer.get();
           return  new ResponseEntity<>(new ErrorResponse(ErrorCode.SUCCESS,customer1), HttpStatus.OK);
       }
       return new ResponseEntity<>(new ErrorResponse(ErrorCode.NOT_FOUND, null), HttpStatus.OK);
   }
    @PutMapping(value = "/{customerId}")
    public ResponseEntity<?> updateCustomer(@PathVariable int customerId, @RequestBody Customer customer){
        boolean status = customerService.updateCustomer(customer,customerId);
        if(status){
            return new ResponseEntity<>(new ErrorResponse(ErrorCode.SUCCESS, null), HttpStatus.OK);
        } else{
            return new ResponseEntity<>(new ErrorResponse(ErrorCode.NOT_FOUND, null), HttpStatus.OK);
        }
    }
    @DeleteMapping( value = "/{customerId}")
    public ResponseEntity<?> deleteCustomer(@PathVariable int customerId){
        customerService.deleteCustomer(customerId);
        return new ResponseEntity<>(new ErrorResponse(ErrorCode.SUCCESS, null), HttpStatus.OK);
    }



}
