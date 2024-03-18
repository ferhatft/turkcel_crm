package com.turkcell.pair6.customerservice.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Table(name = "customers")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer {

    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "middle_name")
    private String middleName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "gender")
    private String gender;

    @Column(name = "mother_name")
    private String motherName;

    @Column(name = "father_name")
    private String fatherName;

    @Column(name = "nationality_id")
    private String nationalityId;

    @Column(name = "birth_date")
    private Date birthDate;

    @OneToMany(mappedBy = "customer")
    private List<Address> addresses;

    @OneToOne(mappedBy = "customer")
    private Contact contact;
}
