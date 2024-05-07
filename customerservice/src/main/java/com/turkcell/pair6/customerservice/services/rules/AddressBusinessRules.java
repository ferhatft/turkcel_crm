package com.turkcell.pair6.customerservice.services.rules;

import com.turkcell.core.exceptions.types.BusinessException;
import com.turkcell.core.service.abstracts.MessageService;
import com.turkcell.core.service.constants.Messages;
import com.turkcell.pair6.customerservice.entities.Address;
import com.turkcell.pair6.customerservice.repositories.AddressRepository;
import com.turkcell.pair6.customerservice.services.abstracts.CustomerService;
import com.turkcell.pair6.customerservice.services.dtos.requests.SetPrimaryAdressRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
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

    public void isAddressIdExist(int id){

        Optional<Address> optionalAddress = addressRepository.findActiveAddressById(id);
        Address address = optionalAddress.orElse(null);

        if (address == null)
            throw new BusinessException(messageService.getMessage(Messages.BusinessErrors.ADDRESS_DOES_NOT_EXIST));

    }

    public void hasCustomerMoreThanOneAddress(int id) {

        Optional<Address> optionalAddress = addressRepository.findActiveAddressById(id);
        Address address = optionalAddress.orElse(null);


        List<Address> adressList= address.getCustomer().getAddresses();
        int isActiveCount = 0;
        for (Address active:
             adressList) {
            if(active.isActive()){
                isActiveCount++;
            }
        }
        if (isActiveCount <= 1 )
            throw new BusinessException(messageService.getMessage(Messages.BusinessErrors.CUSTOMER_HAS_NOT_MORE_THAN_ONE_ADDRESS));
    }



    public void hasCustomerPrimaryAdress(int id) {
        List<Address> optionalAddress = addressRepository.findByCustomerIdAndIsprimaryTrue(id);
        if (optionalAddress == null)
            throw new BusinessException(messageService.getMessage(Messages.BusinessErrors.ADDRESS_DOES_NOT_EXIST));
    }

    public void isAddressBelongToThisCustomer(SetPrimaryAdressRequest request) {
        Address address = addressRepository.findActiveAddressById(request.getAddressId()).orElse(null);
        if (address.getCustomer().getId() != request.getCustomerId())
            throw new BusinessException(messageService.getMessage(Messages.BusinessErrors.THIS_ADDRESS_NOT_BELONG_THIS_CUSTOMER));
    }
}

