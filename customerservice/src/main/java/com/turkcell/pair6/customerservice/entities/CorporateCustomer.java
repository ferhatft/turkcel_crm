package com.turkcell.pair6.customerservice.entities;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Entity
@DiscriminatorValue("corporate")
@Data
public class CorporateCustomer extends Customer {

    public CorporateCustomer() {
    }

    public CorporateCustomer(int id, String customerNo, String firstName, String middleName, String lastName, String gender, String motherName, String fatherName, String nationalityId, Date birthDate, List<Address> addresses, Contact contact) {
        super(id, customerNo, firstName, middleName, lastName, gender, motherName, fatherName, nationalityId, birthDate, addresses, contact);
    }
}