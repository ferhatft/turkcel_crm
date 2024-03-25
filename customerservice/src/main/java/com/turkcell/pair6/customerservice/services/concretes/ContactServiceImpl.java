package com.turkcell.pair6.customerservice.services.concretes;

import com.turkcell.pair6.customerservice.entities.Contact;
import com.turkcell.pair6.customerservice.repositories.ContactRepository;
import com.turkcell.pair6.customerservice.services.abstracts.ContactService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ContactServiceImpl implements ContactService {
    private final ContactRepository contactRepository;

    @Override
    public List<Contact> getAll() {
        return contactRepository.findAll();
    }

    @Override
    public void delete(int id) {
        contactRepository.deleteById(id);
    }
}
