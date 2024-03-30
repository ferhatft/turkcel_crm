package com.turkcell.pair6.customerservice.services.concretes;

import com.turkcell.pair6.customerservice.entities.Address;
import com.turkcell.pair6.customerservice.repositories.AddressRepository;
import com.turkcell.pair6.customerservice.services.abstracts.AddressService;
import com.turkcell.pair6.customerservice.services.dtos.requests.AddAddressRequest;
import com.turkcell.pair6.customerservice.services.dtos.requests.UpdateAddressRequest;
import com.turkcell.pair6.customerservice.services.dtos.responses.AddressResponse;
import com.turkcell.pair6.customerservice.services.mappers.AddressMapper;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class AddressServiceImpl implements AddressService {
    private final AddressRepository addressRepository;
    @Override
    public Page<AddressResponse> getAll(Pageable pageable) {
        Page<Address> addressPage = addressRepository.findAll(pageable);
        return addressPage.map(address -> AddressMapper.INSTANCE.addressResponseFromAddress(address));
    }

    @Override
    public void add(AddAddressRequest request) {
        Address address = AddressMapper.INSTANCE.addressFromAddRequest(request);
        address.setCreatedDate(LocalDateTime.now());
        addressRepository.save(address);
    }

    @Override
    public void delete(int id) {
        addressRepository.deleteById(id);
    }

    @Override
    public void update(UpdateAddressRequest request) {
        List<Address> addresses = addressRepository.findAll();

        for(Address address : addresses){
            if(address.getId()== request.getId()){
                address = AddressMapper.INSTANCE.addressFromUpdateRequest(request);
                address.setUpdatedDate(LocalDateTime.now());
                addressRepository.save(address);
                break;
            }
        }
    }

    @Override
    public Optional<Address> getById(int id) {
        return addressRepository.findById(id);
    }
}
