package com.turkcell.pair6.customerservice.services.rules;

import com.turkcell.core.exceptions.types.BusinessException;
import com.turkcell.core.service.abstracts.MessageService;
import com.turkcell.core.service.constants.Messages;
import com.turkcell.pair6.customerservice.entities.Contact;
import com.turkcell.pair6.customerservice.repositories.ContactRepository;
import com.turkcell.pair6.customerservice.services.abstracts.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@RequiredArgsConstructor
@Component
public class ContactBusinessRules {
    private final CustomerService customerService;
    private final MessageService messageService;
    private final ContactRepository contactRepository;

    public void isCustomerIdExist(int id) {
        if (!customerService.isCustomerIdExist(id)) {
            throw new BusinessException(messageService.getMessage(Messages.BusinessErrors.CUSTOMER_WITH_THAT_ID_NOT_EXIST));
        }
    }

    public void hasCustomerAlreadyContact(int id){
        Optional<Contact> optionalContact =  contactRepository.findActiveContactByCustomerId(id);
        Contact contact = optionalContact.orElse(null);

        if(contact != null){
            throw new BusinessException(messageService.getMessage(Messages.BusinessErrors.CONTACT_HAS_ALREADY_EXIST));
        }
    }

    public void isContactIdExist(int id) {

        Optional<Contact> optionalContact =  contactRepository.findActiveContactById(id);
        Contact contact = optionalContact.orElse(null);

        if (contact == null)
            throw new BusinessException(messageService.getMessage(Messages.BusinessErrors.CONTACT_DOES_NOT_EXIST));
    }
}
