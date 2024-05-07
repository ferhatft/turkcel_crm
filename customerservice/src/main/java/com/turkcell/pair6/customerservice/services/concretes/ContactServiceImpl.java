package com.turkcell.pair6.customerservice.services.concretes;

import com.turkcell.pair6.customerservice.entities.Contact;
import com.turkcell.pair6.customerservice.repositories.ContactRepository;
import com.turkcell.pair6.customerservice.services.abstracts.ContactService;
import com.turkcell.pair6.customerservice.services.dtos.requests.AddContactRequest;
import com.turkcell.pair6.customerservice.services.dtos.requests.UpdateContactRequest;
import com.turkcell.pair6.customerservice.services.dtos.responses.ContactResponse;
import com.turkcell.pair6.customerservice.services.mappers.ContactMapper;
import com.turkcell.pair6.customerservice.services.rules.ContactBusinessRules;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ContactServiceImpl implements ContactService {


    private final ContactRepository contactRepository;
    private final ContactBusinessRules contactBusinessRules;

    @Override
    public List<ContactResponse> getAllActive(Pageable pageable) {
        Page<Contact> contactPage = contactRepository.findAllByIsActiveTrue(pageable);
        return contactPage.map(ContactMapper.INSTANCE::contactResponseFromContact).getContent();
    }

    @Override
    public void delete(int id) {
        contactBusinessRules.isContactIdExist(id);
        contactRepository.deactivateByContactId(id);
    }

    @Override
    public ContactResponse getById(int id) {
        contactBusinessRules.isContactIdExist(id);
        Optional<Contact> optionalContact =  contactRepository.findActiveContactById(id);
        Contact contact = optionalContact.orElse(null);

        return ContactMapper.INSTANCE.contactResponseFromContact(contact);
    }

    @Override
    public void add(AddContactRequest request) {
        contactBusinessRules.isCustomerIdExist(request.getCustomerId());
        contactBusinessRules.hasCustomerAlreadyContact(request.getCustomerId());
        Contact contact = ContactMapper.INSTANCE.contactFromAddRequest(request);
        contactRepository.save(contact);
    }

    @Override
    public void update(UpdateContactRequest request) {
        contactBusinessRules.isContactIdExist(request.getId());

        Optional<Contact> optionalContact = contactRepository.findActiveContactById(request.getId());
        Contact contact = optionalContact.orElse(null);

        Contact updatedContact = ContactMapper.INSTANCE.contactFromUpdateRequest(request, contact);
        contactRepository.save(updatedContact);
    }
}
