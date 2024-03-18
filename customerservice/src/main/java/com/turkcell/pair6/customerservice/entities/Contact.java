package com.turkcell.pair6.customerservice.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "contacts")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Contact {
    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "email")
    private String email;

    @Column(name = "home_phone")
    private String homePhone;

    @Column(name = "mobile_phone")
    private String mobilePhone;

    @Column(name = "fax")
    private String fax;

    @OneToOne()
    @JoinColumn(name = "customer_id")
    private Customer customer;
}
