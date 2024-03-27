package com.turkcell.pair6.customerservice.services.concretes;

import com.turkcell.pair6.customerservice.clients.OrderServiceClient;
import com.turkcell.pair6.customerservice.core.exception.types.BusinessException;
import com.turkcell.pair6.customerservice.entities.Customer;
import com.turkcell.pair6.customerservice.repositories.CustomerRepository;
import com.turkcell.pair6.customerservice.services.dtos.requests.AddCustomerRequest;
import com.turkcell.pair6.customerservice.services.dtos.requests.AddDemographicRequest;
import com.turkcell.pair6.customerservice.services.dtos.requests.SearchCustomerRequest;
import com.turkcell.pair6.customerservice.services.dtos.requests.UpdateCustomerRequest;
import com.turkcell.pair6.customerservice.services.dtos.responses.SearchCustomerResponse;
import com.turkcell.pair6.customerservice.services.mappers.CustomerMapper;
import com.turkcell.pair6.customerservice.services.rules.CustomerBusinessRules;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.turkcell.pair6.customerservice.services.abstracts.CustomerService;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;
    private final WebClient.Builder webClient;
    private final CustomerBusinessRules customerBusinessRules;
    private final OrderServiceClient orderServiceClient;

    @Override
    public List<Customer> getAll() {
        return customerRepository.findAll();
    }

    @Override
    public List<SearchCustomerResponse> search(SearchCustomerRequest request) {
        customerBusinessRules.customerNoExist(request);

        int result = orderServiceClient.getCustomerIdByOrderId(request.getOrderNumber());
        request.setOrderNumber(String.valueOf(result));

        return customerRepository.search(request);
    }

    @Override
    public void add(AddCustomerRequest request) {
        Customer customer = CustomerMapper.INSTANCE.customerFromAddRequest(request);
        customerRepository.save(customer);
    }

    @Override
    public void add(AddDemographicRequest request) {
        customerBusinessRules.customerWithSameNationalityIdCanNotExist(request.getNationalityId());

        Customer customer = CustomerMapper.INSTANCE.customerFromAddDemographicRequest(request);
        customerRepository.save(customer);
    }

    @Override
    public void delete(int id) {
        customerRepository.deleteById(id);
    }

    @Override
    public void update(UpdateCustomerRequest request) {
        customerBusinessRules.customerIdExist(request.getId());

        List<Customer> customers = customerRepository.findAll();

        for (Customer customer : customers) {
            if (customer.getId() == request.getId()) {
                customer = CustomerMapper.INSTANCE.customerFromUpdateRequest(request);
                customerRepository.save(customer);
                break;
            }
        }
    }


}
