package com.cnpm.workingspace.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "customer")
@Getter
@Setter
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id", nullable = false)
    private Integer customerId;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "account_id", nullable = false)
    private Account account;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "customer_name", nullable = false)
    private String customerName;

    @Column(name = "citizen_id", nullable = false)
    private String citizenId;

    @Column(name = "birthday", nullable = false)
    private LocalDate birthday;

    @Column(name = "nationality", nullable = false)
    private String nationality;

    @Column(name = "phone_number", nullable = false)
    private String phoneNumber;

    public Customer() {
    }

    public Customer(String email, String customerName, String phoneNumber) {
        this.email = email;
        this.customerName = customerName;
        this.phoneNumber = phoneNumber;
    }
}
