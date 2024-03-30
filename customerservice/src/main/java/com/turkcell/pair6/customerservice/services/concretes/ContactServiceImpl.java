package com.turkcell.pair6.customerservice.services.concretes;

import com.turkcell.pair6.customerservice.entities.Contact;
import com.turkcell.pair6.customerservice.repositories.ContactRepository;
import com.turkcell.pair6.customerservice.services.abstracts.ContactService;
import com.turkcell.pair6.customerservice.services.dtos.requests.AddContactRequest;
import com.turkcell.pair6.customerservice.services.dtos.responses.ContactResponse;
import com.turkcell.pair6.customerservice.services.mappers.ContactMapper;
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

    @Override
    public Page<ContactResponse> getAll(Pageable pageable) {
        Page<Contact> contactPage = contactRepository.findAll(pageable);
        return contactPage.map(contact -> ContactMapper.INSTANCE.contactResponseFromContact(contact));
    }

    @Override
    public void delete(int id) {
        contactRepository.deleteById(id);
    }

    @Override
    public Optional<Contact> getById(int id) {
        return contactRepository.findById(id);
    }

    @Override
    public void add(AddContactRequest request) {
        Contact contact = ContactMapper.INSTANCE.contactFromAddRequest(request);
        contact.setCreatedDate(LocalDateTime.now());
        contactRepository.save(contact);
    }
}
