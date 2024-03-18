package com.turkcell.pair6.customerservice.controllers;

import com.turkcell.pair6.customerservice.entities.Address;
import com.turkcell.pair6.customerservice.services.abstracts.AddressService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/addresses")
@AllArgsConstructor
public class AddressController {
    private final AddressService addressService;

    @GetMapping
    public List<Address> getAll() {
        return addressService.getAll();
    }
}
