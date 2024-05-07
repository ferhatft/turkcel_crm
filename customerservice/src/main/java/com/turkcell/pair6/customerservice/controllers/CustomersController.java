package com.turkcell.pair6.customerservice.controllers;

import com.turkcell.pair6.customerservice.entities.Customer;
import com.turkcell.pair6.customerservice.services.dtos.requests.*;
import com.turkcell.pair6.customerservice.services.dtos.responses.AddCustomerResponse;
import com.turkcell.pair6.customerservice.services.dtos.responses.SearchCustomerResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;
import com.turkcell.pair6.customerservice.services.abstracts.CustomerService;

import java.util.List;

@RestController
@RequestMapping("/api/customers")
@AllArgsConstructor
public class CustomersController {

    private final CustomerService customerService;

    @GetMapping
    public List<AddCustomerResponse> getAll(@RequestParam(defaultValue = "0") int pageNumber,
                                 @RequestParam(defaultValue = "10") int pageSize) {
        return customerService.getAll(PageRequest.of(pageNumber, pageSize));
    }

    @PostMapping("search")
    public List<SearchCustomerResponse> search(@RequestBody @Valid SearchCustomerRequest request){
        return customerService.search(request);
    }

    @PostMapping("demographic")
    public AddCustomerResponse add(@RequestBody @Valid AddDemographicRequest request)
    {


        return customerService.add(request);
    }

    @DeleteMapping
    public void delete(@RequestParam String nationalityId) {
        customerService.delete(nationalityId);
    }

    @PutMapping
    public AddCustomerResponse update(@RequestBody @Valid UpdateCustomerRequest updateCustomerRequest) {
       return customerService.update(updateCustomerRequest);
    }

}
