package com.turkcell.pair6.customerservice.services.abstracts;


import com.turkcell.pair6.customerservice.entities.Address;
import com.turkcell.pair6.customerservice.services.dtos.requests.AddAddressRequest;
import com.turkcell.pair6.customerservice.services.dtos.requests.UpdateAddressRequest;

import java.util.List;
import java.util.Optional;

public interface AddressService {
    List<Address> getAll();

    void add(AddAddressRequest request);

    void delete(int id);

    void update(UpdateAddressRequest updateAddressRequest);

    Optional<Address> getById(int id);
}
