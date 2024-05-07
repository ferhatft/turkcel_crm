package com.turkcell.pair6.customerservice.services.concretes;

import com.turkcell.pair6.customerservice.entities.Address;
import com.turkcell.pair6.customerservice.repositories.AddressRepository;
import com.turkcell.pair6.customerservice.services.abstracts.AddressService;
import com.turkcell.pair6.customerservice.services.dtos.requests.AddAddressRequest;
import com.turkcell.pair6.customerservice.services.dtos.requests.SetPrimaryAdressRequest;
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

    public List<AddressResponse> getAllActive(Pageable pageable) {
        Page<Address> addressPage = addressRepository.findAllByIsActiveTrue(pageable);
        return addressPage.map(AddressMapper.INSTANCE::addressResponseFromAddress).getContent();
    }

    @Override
    public int add(AddAddressRequest request) {
        addressBusinessRules.isCustomerIdExist(request.getCustomerId());
        Address address = AddressMapper.INSTANCE.addressFromAddRequest(request);
        addressRepository.save(address);
        return address.getId();
    }

    @Override
    public void delete(int id) {
        addressBusinessRules.isAddressIdExist(id);
        addressBusinessRules.hasCustomerMoreThanOneAddress(id);
        addressRepository.deactivateByAddressId(id);
    }

    @Override
    public void update(UpdateAddressRequest request) {
        addressBusinessRules.isAddressIdExist(request.getId());

        Optional<Address> optionalAddress = addressRepository.findActiveAddressById(request.getId());
        Address address = optionalAddress.orElse(null);


        Address updatedAddress = AddressMapper.INSTANCE.addressFromUpdateRequest(request , address);
        addressRepository.save(updatedAddress);
    }


    @Override
    public void setprimary(SetPrimaryAdressRequest request) {
        addressBusinessRules.isCustomerIdExist(request.getCustomerId());
        addressBusinessRules.isAddressIdExist(request.getAddressId());
        addressBusinessRules.isAddressBelongToThisCustomer(request);

        List<Address>  primaryAddresslist = addressRepository.findByCustomerIdAndIsprimaryTrue(request.getCustomerId());
        for (Address address : primaryAddresslist){
            address.setIsprimary(false);
        }

        Address address = addressRepository.findById(request.getAddressId()).orElse(null);
        if (address != null) {
            address.setIsprimary(true);
            addressRepository.save(address);
        }
    }

    @Override
    public AddressResponse getById(int id) {
        addressBusinessRules.isAddressIdExist(id);
        Optional<Address> optionalAddress = addressRepository.findActiveAddressById(id);
        Address address = optionalAddress.orElse(null);

        return AddressMapper.INSTANCE.addressResponseFromAddress(address);
    }



}
