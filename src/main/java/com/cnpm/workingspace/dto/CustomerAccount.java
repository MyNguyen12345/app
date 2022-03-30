package com.cnpm.workingspace.dto;

import com.cnpm.workingspace.model.Account;
import com.cnpm.workingspace.model.Customer;

import java.util.Date;

public class CustomerAccount {
    private String username;
    private String password;

    private String email;
    private String customerName;
    private String citizenId;
    private Date birthday;
    private String nationality;
    private String phoneNumber;

    public CustomerAccount(String username, String password, String email, String customerName, String citizenId, Date birthday, String nationality, String phoneNumber) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.customerName = customerName;
        this.citizenId = citizenId;
        this.birthday = birthday;
        this.nationality = nationality;
        this.phoneNumber = phoneNumber;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCitizenId() {
        return citizenId;
    }

    public void setCitizenId(String citizenId) {
        this.citizenId = citizenId;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Account getAccount(){
        return new Account(username,password);
    }

    public Customer getCustomer(){
        return new Customer(email,customerName,citizenId,birthday,nationality,phoneNumber);
    }
}
