package com.turkcell.pair6.customerservice.services.concretes;

import com.turkcell.pair6.customerservice.entities.Address;
import com.turkcell.pair6.customerservice.repositories.AddressRepository;
import com.turkcell.pair6.customerservice.services.abstracts.AddressService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class AddressServiceImpl implements AddressService {
    private final AddressRepository addressRepository;
    @Override
    public List<Address> getAll() {
        return addressRepository.findAll();
    }
}
