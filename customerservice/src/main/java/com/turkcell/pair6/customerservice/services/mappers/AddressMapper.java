package com.turkcell.pair6.customerservice.services.mappers;

import com.turkcell.pair6.customerservice.entities.Address;
import com.turkcell.pair6.customerservice.services.dtos.requests.AddAddressRequest;
import com.turkcell.pair6.customerservice.services.dtos.requests.UpdateAddressRequest;
import com.turkcell.pair6.customerservice.services.dtos.responses.AddressResponse;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AddressMapper {
    AddressMapper INSTANCE = Mappers.getMapper(AddressMapper.class);

    Address addressFromAddRequest(AddAddressRequest request);
    Address addressFromUpdateRequest(UpdateAddressRequest request , @MappingTarget Address address) ;

    AddressResponse addressResponseFromAddress(Address address);
}
