package com.turkcell.pair6.customerservice.controllers;

import com.turkcell.pair6.customerservice.entities.Contact;
import com.turkcell.pair6.customerservice.services.abstracts.ContactService;
import com.turkcell.pair6.customerservice.services.dtos.requests.AddContactRequest;
import com.turkcell.pair6.customerservice.services.dtos.responses.AddressResponse;
import com.turkcell.pair6.customerservice.services.dtos.responses.ContactResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/contacts")
@AllArgsConstructor
public class ContactController {
    private final ContactService contactService;

    @GetMapping
    public Page<ContactResponse> getAll(@RequestParam(defaultValue = "0") int pageNumber,
                                        @RequestParam(defaultValue = "10") int pageSize) {
        return contactService.getAll(PageRequest.of(pageNumber, pageSize));
    }

    @GetMapping("getById")
    public Optional<Contact> getById(int id){
        return contactService.getById(id);
    }

    @DeleteMapping
    public void delete(int id){
        contactService.delete(id);
    }

    @PostMapping
    public void add (@RequestBody @Valid AddContactRequest request){
        contactService.add(request);
    }
}
