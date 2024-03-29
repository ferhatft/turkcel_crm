package com.turkcell.pair6.customerservice.services.mappers;

import com.turkcell.pair6.customerservice.entities.Customer;
import com.turkcell.pair6.customerservice.services.dtos.requests.AddDemographicRequest;
import com.turkcell.pair6.customerservice.services.dtos.requests.UpdateCustomerRequest;
import com.turkcell.pair6.customerservice.services.dtos.responses.AddCustomerResponse;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CustomerMapper {

    CustomerMapper INSTANCE = Mappers.getMapper(CustomerMapper.class);


    Customer customerFromUpdateRequest(UpdateCustomerRequest request);

    Customer customerFromAddDemographicRequest(AddDemographicRequest request);

    AddCustomerResponse customerResponseFromAddDemographicRequest(AddDemographicRequest request);

    AddCustomerResponse customerResponseFromCustomer(Customer request);
}
