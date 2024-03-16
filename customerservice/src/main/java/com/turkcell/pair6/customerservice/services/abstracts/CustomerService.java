package com.turkcell.pair6.customerservice.services.abstracts;

import com.turkcell.pair6.customerservice.entities.Customer;

import java.util.List;

public interface CustomerService {
    List<Customer> getAll();
}
