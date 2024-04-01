package com.turkcell.pair6.customerservice.services.rules;

import com.turkcell.pair6.customerservice.core.exception.types.BusinessException;
import com.turkcell.pair6.customerservice.entities.Customer;
import com.turkcell.pair6.customerservice.entities.IndividualCustomer;
import com.turkcell.pair6.customerservice.repositories.CustomerRepository;
import com.turkcell.pair6.customerservice.services.dtos.requests.SearchCustomerRequest;
import com.turkcell.pair6.customerservice.services.messages.CustomerMessages;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@RequiredArgsConstructor
@Component
public class CustomerBusinessRules {
    private final CustomerRepository customerRepository;



    public void customerNatIdExist(String nationalityId)
    {
        Optional<IndividualCustomer> customer = customerRepository.findByNationalityId(nationalityId);

        if(customer.isEmpty())
            throw new BusinessException(CustomerMessages.customerNatIdExist);
    }

    public void customerNoExist(SearchCustomerRequest request)
    {
        if (customerRepository.search(request).isEmpty()) {
            throw new BusinessException(CustomerMessages.customerNoExists);
        }
    }

    public void customerWithSameNationalityIdCanNotExist(String nationalityId)
    {
        Optional<IndividualCustomer> customer = customerRepository.findByNationalityId(nationalityId);

        if(customer.isPresent())
            throw new BusinessException(CustomerMessages.customerExistsWithSameNationalityId);
    }
}
