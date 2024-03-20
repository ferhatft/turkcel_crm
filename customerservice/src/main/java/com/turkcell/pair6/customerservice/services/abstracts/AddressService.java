package com.turkcell.pair6.customerservice.services.abstracts;


import com.turkcell.pair6.customerservice.entities.Address;
import com.turkcell.pair6.customerservice.services.dtos.requests.AddAddressRequest;

import java.util.List;

public interface AddressService {
    List<Address> getAll();

    void add(AddAddressRequest request);
}
