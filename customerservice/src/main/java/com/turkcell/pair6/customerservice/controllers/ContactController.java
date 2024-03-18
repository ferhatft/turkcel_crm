package com.turkcell.pair6.customerservice.controllers;

import com.turkcell.pair6.customerservice.entities.Contact;
import com.turkcell.pair6.customerservice.services.abstracts.ContactService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/contacts")
@AllArgsConstructor
public class ContactController {
    private final ContactService contactService;

    @GetMapping
    public List<Contact> getAll() {
        return contactService.getAll();
    }
}
