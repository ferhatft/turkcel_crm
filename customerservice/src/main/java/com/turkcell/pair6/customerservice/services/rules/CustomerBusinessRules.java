package com.turkcell.pair6.customerservice.services.rules;

import com.turkcell.pair6.customerservice.clients.OrderServiceClient;
import com.turkcell.pair6.customerservice.core.exception.types.BusinessException;
import com.turkcell.pair6.customerservice.core.service.abstracts.MessageService;
import com.turkcell.pair6.customerservice.core.service.constants.Messages;
import com.turkcell.pair6.customerservice.entities.IndividualCustomer;
import com.turkcell.pair6.customerservice.repositories.CustomerRepository;
import com.turkcell.pair6.customerservice.services.dtos.requests.SearchCustomerRequest;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@RequiredArgsConstructor
@Component
public class CustomerBusinessRules {
    private final CustomerRepository customerRepository;
    private final MessageService messageService;
    private final OrderServiceClient orderServiceClient;


    public void customerNatIdExist(String nationalityId)
    {
        Optional<IndividualCustomer> customer = customerRepository.findByNationalityId(nationalityId);

        if(customer.isEmpty())
            throw new BusinessException(messageService.getMessage(Messages.BusinessErrors.CUSTOMER_NATID_EXIST));
    }

    public void customerNoExist(SearchCustomerRequest request)
    {
        if (customerRepository.search(request).isEmpty()) {
            throw new BusinessException(messageService.getMessage(Messages.BusinessErrors.CUSTOMER_NOT_EXIST));
        }
    }

    public void customerWithSameNationalityIdCanNotExist(String nationalityId)
    {
        Optional<IndividualCustomer> customer = customerRepository.findByNationalityId(nationalityId);

        if(customer.isPresent())
            throw new BusinessException(messageService.getMessage(Messages.BusinessErrors.CUSTOMER_EXIST_WITH_SAME_NATID));
    }

    public void hasCustomerProduct(String nationalityId) {
        if(orderServiceClient.hasCustomerProduct(nationalityId))
            throw new BusinessException(messageService.getMessage(Messages.BusinessErrors.CUSTOMER_HAS_PRODUCT));
    }
}
