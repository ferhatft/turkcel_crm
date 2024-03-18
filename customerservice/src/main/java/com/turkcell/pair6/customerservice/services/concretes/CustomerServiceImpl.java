package com.turkcell.pair6.customerservice.services.concretes;

import com.turkcell.pair6.customerservice.core.exception.types.BusinessException;
import com.turkcell.pair6.customerservice.entities.Customer;
import com.turkcell.pair6.customerservice.repositories.CustomerRepository;
import com.turkcell.pair6.customerservice.services.dtos.requests.AddCustomerRequest;
import com.turkcell.pair6.customerservice.services.dtos.requests.SearchCustomerRequest;
import com.turkcell.pair6.customerservice.services.dtos.responses.SearchCustomerResponse;
import com.turkcell.pair6.customerservice.services.mappers.CustomerMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import com.turkcell.pair6.customerservice.services.abstracts.CustomerService;

import java.util.List;

@Service
@AllArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private  final CustomerRepository customerRepository;
    @Override
    public List<Customer> getAll() {
        return customerRepository.findAll();
    }

    @Override
    public List<SearchCustomerResponse> search(SearchCustomerRequest request) {
        if (customerRepository.search(request).isEmpty()){
            throw new BusinessException("No customer found! Would you like to create the customer?");
        }

        return customerRepository.search(request);
    }

    @Override
    public void add(AddCustomerRequest request) {
        Customer customer = CustomerMapper.INSTANCE.customerFromAddRequest(request);

        customerRepository.save(customer);
    }


}
