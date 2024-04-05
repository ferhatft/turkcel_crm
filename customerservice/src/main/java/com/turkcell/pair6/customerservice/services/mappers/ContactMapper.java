package com.turkcell.pair6.customerservice.services.mappers;

import com.turkcell.pair6.customerservice.entities.Contact;
import com.turkcell.pair6.customerservice.services.dtos.requests.AddContactRequest;
import com.turkcell.pair6.customerservice.services.dtos.requests.UpdateContactRequest;
import com.turkcell.pair6.customerservice.services.dtos.responses.ContactResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ContactMapper {
    ContactMapper INSTANCE = Mappers.getMapper(ContactMapper.class);

    @Mapping(source="customerId", target="customer.id")
    Contact contactFromAddRequest(AddContactRequest request);

    ContactResponse contactResponseFromContact(Contact contact);

    Contact contactFromUpdateRequest(UpdateContactRequest request , @MappingTarget Contact contact);
}
