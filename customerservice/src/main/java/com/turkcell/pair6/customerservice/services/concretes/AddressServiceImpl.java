package com.turkcell.pair6.customerservice.services.concretes;

import com.turkcell.pair6.customerservice.entities.Address;
import com.turkcell.pair6.customerservice.repositories.AddressRepository;
import com.turkcell.pair6.customerservice.services.abstracts.AddressService;
import com.turkcell.pair6.customerservice.services.dtos.requests.AddAddressRequest;
import com.turkcell.pair6.customerservice.services.dtos.requests.UpdateAddressRequest;
import com.turkcell.pair6.customerservice.services.dtos.responses.AddressResponse;
import com.turkcell.pair6.customerservice.services.mappers.AddressMapper;
import com.turkcell.pair6.customerservice.services.rules.AddressBusinessRules;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class AddressServiceImpl implements AddressService {
    private final AddressRepository addressRepository;
    private final AddressBusinessRules addressBusinessRules;

    @Override
    public List<AddressResponse> getAll(Pageable pageable) {
        Page<Address> addressPage = addressRepository.findAll(pageable);
        return addressPage.map(AddressMapper.INSTANCE::addressResponseFromAddress).getContent();
    }

    @Override
    public void add(AddAddressRequest request) {
        addressBusinessRules.isCustomerIdExist(request.getCustomerId());
        Address address = AddressMapper.INSTANCE.addressFromAddRequest(request);
        addressRepository.save(address);
    }

    @Override
    public void delete(int id) {
        addressBusinessRules.hasCustomerMoreThanOneAddress(id);
        addressRepository.deleteById(id);
    }

    @Override
    public void update(UpdateAddressRequest request) {
        Optional<Address> optionalAddress = addressRepository.findById(request.getId());
        Address address = optionalAddress.orElse(null);

        Address updatedAddress = AddressMapper.INSTANCE.addressFromUpdateRequest(request , address);
        addressRepository.save(updatedAddress);
    }

    @Override
    public Optional<Address> getById(int id) {
        return addressRepository.findById(id);
    }
}
