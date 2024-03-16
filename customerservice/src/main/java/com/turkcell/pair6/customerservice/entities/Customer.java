package com.turkcell.pair6.customerservice.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

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
    @Column(name = "firstname")
    private String firstName;
    @Column(name = "middlename")
    private String middleName;
    @Column(name = "lastname")
    private String lastName;
    @Column(name = "gender")
    private String gender;
    @Column(name = "mothername")
    private String motherName;
    @Column(name = "fathername")
    private String fatherName;
    @Column(name = "nationalityid")
    private String nationalityId;
    @Column(name = "birthdate")
    private Date birthDate;


}
