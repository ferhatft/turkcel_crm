package com.turkcell.pair6.customerservice.services.abstracts;

import com.turkcell.pair6.customerservice.entities.Customer;
import com.turkcell.pair6.customerservice.services.dtos.requests.SearchCustomerRequest;
import com.turkcell.pair6.customerservice.services.dtos.responses.SearchCustomerResponse;

import java.util.List;

public interface CustomerService {
    List<Customer> getAll();

    List<SearchCustomerResponse> search(SearchCustomerRequest request);
}
