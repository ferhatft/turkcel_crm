package com.turkcell.pair6.customerservice.services.abstracts;

import com.turkcell.pair6.customerservice.entities.Customer;
import com.turkcell.pair6.customerservice.services.dtos.requests.AddDemographicRequest;
import com.turkcell.pair6.customerservice.services.dtos.requests.SearchCustomerRequest;
import com.turkcell.pair6.customerservice.services.dtos.requests.UpdateCustomerRequest;
import com.turkcell.pair6.customerservice.services.dtos.responses.AddCustomerResponse;
import com.turkcell.pair6.customerservice.services.dtos.responses.SearchCustomerResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CustomerService {
    List<AddCustomerResponse> getAll(Pageable pageable);

    List<SearchCustomerResponse> search(SearchCustomerRequest request);

    AddCustomerResponse add(AddDemographicRequest request);

    void delete(String nationalityId);

    AddCustomerResponse update(UpdateCustomerRequest updateCustomerRequest);

    boolean isCustomerIdExist(int id);
}
