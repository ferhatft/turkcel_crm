package com.turkcell.pair6.customerservice.services.rules;

import com.turkcell.pair6.customerservice.core.exception.types.BusinessException;
import com.turkcell.pair6.customerservice.core.service.abstracts.MessageService;
import com.turkcell.pair6.customerservice.core.service.constants.Messages;
import com.turkcell.pair6.customerservice.entities.Address;
import com.turkcell.pair6.customerservice.repositories.AddressRepository;
import com.turkcell.pair6.customerservice.services.abstracts.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@RequiredArgsConstructor
@Component
public class AddressBusinessRules {
    private final AddressRepository addressRepository;
    private final CustomerService customerService;
    private final MessageService messageService;

    public void isCustomerIdExist(int id){
        if(!customerService.isCustomerIdExist(id)){
            throw new BusinessException(messageService.getMessage(Messages.BusinessErrors.CUSTOMER_WITH_THAT_ID_NOT_EXIST));
        }
    }

    public void hasCustomerMoreThanOneAddress(int id) {
        Optional<Address> optionalAddress = addressRepository.findById(id);
        Address address = optionalAddress.orElse(null);

        if (address.getCustomer().getAddresses().size() <= 1)
            throw new BusinessException(messageService.getMessage(Messages.BusinessErrors.CUSTOMER_HAS_NOT_MORE_THAN_ONE_ADDRESS));
    }
}
