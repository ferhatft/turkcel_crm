package com.turkcell.pair6.customerservice.services.concretes;

import com.turkcell.pair6.customerservice.entities.Customer;
import com.turkcell.pair6.customerservice.entities.IndividualCustomer;
import com.turkcell.pair6.customerservice.repositories.CustomerRepository;
import com.turkcell.pair6.customerservice.services.abstracts.CustomerService;
import com.turkcell.pair6.customerservice.services.dtos.requests.AddDemographicRequest;
import com.turkcell.pair6.customerservice.services.dtos.requests.SearchCustomerRequest;
import com.turkcell.pair6.customerservice.services.dtos.requests.UpdateCustomerRequest;
import com.turkcell.pair6.customerservice.services.dtos.responses.AddCustomerResponse;
import com.turkcell.pair6.customerservice.services.dtos.responses.SearchCustomerResponse;
import com.turkcell.pair6.customerservice.services.mappers.CustomerMapper;
import com.turkcell.pair6.customerservice.services.rules.CustomerBusinessRules;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;
    private final CustomerBusinessRules customerBusinessRules;

    @Override
    public Page<AddCustomerResponse> getAll(Pageable pageable) {
        Page<Customer> customerPage = customerRepository.findAll(pageable);
        return customerPage.map(customer -> CustomerMapper.INSTANCE.customerResponseFromCustomer((IndividualCustomer) customer));
    }

    @Override
    public List<SearchCustomerResponse> search(SearchCustomerRequest request) {
        customerBusinessRules.customerNoExist(request);
        return customerRepository.search(request);
    }

    @Override
    public AddCustomerResponse add(AddDemographicRequest request) {
        customerBusinessRules.customerWithSameNationalityIdCanNotExist(request.getNationalityId());

        Customer customer = CustomerMapper.INSTANCE.customerFromAddDemographicRequest(request);
        customer.setCreatedDate(LocalDateTime.now());
        customerRepository.save(customer);

        return CustomerMapper.INSTANCE.customerResponseFromAddDemographicRequest(request);

    }

    @Override
    public void delete(int id) {
        customerRepository.deleteById(id);
    }

    @Override
    public AddCustomerResponse update(UpdateCustomerRequest request) {
        customerBusinessRules.customerNatIdExist(request.getNationalityId());

        Optional<Customer> optionalCustomer = customerRepository.findByNationalityId(request.getNationalityId());
        Customer customer = optionalCustomer.orElse(null);

        Customer updatedCustomer = CustomerMapper.INSTANCE.customerFromUpdateRequest(request);
        updatedCustomer.setUpdatedDate(LocalDateTime.now());
        updatedCustomer.setId(customer.getId());
        customerRepository.save(updatedCustomer);

        return CustomerMapper.INSTANCE.customerResponseFromCustomer((IndividualCustomer) updatedCustomer);
    }



}
