package com.cnpm.workingspace.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "customer")
@Getter
@Setter
public class Customer {
    @JsonIgnore
    @Id
    @Column(name = "customer_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int customerId;

    @JsonIgnore
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "account_id")
    private Account account;
    @Column(name = "email")
    private String email;
    @Column(name = "customer_name")
    private String customerName;
    @Column(name = "citizen_id")
    private String citizenId = "1";
    @Column(name = "birthday")
    private Date birthday = new Date();
    @Column(name = "nationality")
    private String nationality = "VietNam";
    @Column(name = "phone_number")
    private String phoneNumber;

    public Customer() {
    }

    public Customer(String email, String customerName, String phoneNumber) {
        this.email = email;
        this.customerName = customerName;
        this.phoneNumber = phoneNumber;
    }
}
