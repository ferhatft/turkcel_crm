package com.turkcell.pair6.customerservice.services.rules;

import com.turkcell.pair6.customerservice.core.exception.types.BusinessException;
import com.turkcell.pair6.customerservice.core.service.abstracts.MessageService;
import com.turkcell.pair6.customerservice.core.service.constants.Messages;
import com.turkcell.pair6.customerservice.services.abstracts.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class AddressBusinessRules {
    private final CustomerService customerService;
    private final MessageService messageService;

    public void isCustomerIdExist(int id){
        if(!customerService.isCustomerIdExist(id)){
            throw new BusinessException(messageService.getMessage(Messages.BusinessErrors.CUSTOMER_WITH_THAT_ID_NOT_EXIST));
        }
    }

}
