package com.turkcell.pair6.customerservice.services.mappers;

import com.turkcell.pair6.customerservice.entities.Customer;
import com.turkcell.pair6.customerservice.services.dtos.requests.AddCustomerRequest;
import com.turkcell.pair6.customerservice.services.dtos.requests.AddDemographicRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CustomerMapper {

    CustomerMapper INSTANCE = Mappers.getMapper(CustomerMapper.class);

    Customer customerFromAddRequest(AddCustomerRequest request);

    Customer customerFromAddDemographicRequest(AddDemographicRequest request);
}
