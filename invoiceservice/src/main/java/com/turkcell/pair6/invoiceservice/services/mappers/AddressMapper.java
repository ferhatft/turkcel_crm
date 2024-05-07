package com.turkcell.pair6.invoiceservice.services.mappers;

import com.turkcell.pair6.invoiceservice.services.dtos.requests.AddAddressRequest;
import com.turkcell.pair6.invoiceservice.services.dtos.requests.AddressRequest;
import com.turkcell.pair6.invoiceservice.services.dtos.requests.UpdateAddressRequest;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AddressMapper {
    AddressMapper INSTANCE = Mappers.getMapper(AddressMapper.class);

    AddAddressRequest addAddress(AddressRequest request);
    UpdateAddressRequest updateAddress(AddressRequest request);
}
