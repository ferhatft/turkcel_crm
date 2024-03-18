package com.turkcell.pair6.customerservice.controllers;

import com.turkcell.pair6.customerservice.entities.Customer;
import com.turkcell.pair6.customerservice.services.dtos.requests.SearchCustomerRequest;
import com.turkcell.pair6.customerservice.services.dtos.responses.SearchCustomerResponse;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import com.turkcell.pair6.customerservice.services.abstracts.CustomerService;

import java.util.List;

@RestController
@RequestMapping("/api/customers")
@AllArgsConstructor
public class CustomersController {

    private final CustomerService customerService;

    @GetMapping
    public List<Customer> getAll() {
        return customerService.getAll();
    }

    @PostMapping
    public List<SearchCustomerResponse> search(@RequestBody SearchCustomerRequest request){
        return customerService.search(request);
    }

}
