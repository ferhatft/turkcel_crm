package com.turkcell.pair6.customerservice.services.abstracts;


import com.turkcell.pair6.customerservice.entities.Address;
import com.turkcell.pair6.customerservice.services.dtos.requests.AddAddressRequest;
import com.turkcell.pair6.customerservice.services.dtos.requests.SetPrimaryAdressRequest;
import com.turkcell.pair6.customerservice.services.dtos.requests.UpdateAddressRequest;
import com.turkcell.pair6.customerservice.services.dtos.responses.AddressResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface AddressService {
    List<AddressResponse> getAllActive(Pageable pageable);

    int add(AddAddressRequest request);

    void delete(int id);

    void update(UpdateAddressRequest updateAddressRequest);


    void setprimary(SetPrimaryAdressRequest request);

    AddressResponse getById(int id);
}
