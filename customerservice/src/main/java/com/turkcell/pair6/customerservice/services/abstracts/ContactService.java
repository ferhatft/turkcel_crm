package com.turkcell.pair6.customerservice.services.abstracts;

import com.turkcell.pair6.customerservice.entities.Contact;
import com.turkcell.pair6.customerservice.services.dtos.requests.AddContactRequest;
import com.turkcell.pair6.customerservice.services.dtos.requests.UpdateContactRequest;
import com.turkcell.pair6.customerservice.services.dtos.responses.ContactResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface ContactService {

    List<ContactResponse> getAllActive(Pageable pageable);

    void delete(int id);

    ContactResponse getById(int id);

    void add(AddContactRequest request);

    void update(UpdateContactRequest request);
}
