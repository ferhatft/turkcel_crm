package com.turkcell.pair6.invoiceservice.services.mappers;


import com.turkcell.pair6.invoiceservice.entities.Account;
import com.turkcell.pair6.invoiceservice.services.dtos.requests.AddBillingRequest;
import com.turkcell.pair6.invoiceservice.services.dtos.requests.UpdateAccountRequest;
import com.turkcell.pair6.invoiceservice.services.dtos.responses.AccountResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AccountMapper {
    AccountMapper INSTANCE = Mappers.getMapper(AccountMapper.class);

    Account accountFromAddRequest(AddBillingRequest request);

    AccountResponse accountResponseFromAccount(Account account);

    Account accountFromUpdateRequest(UpdateAccountRequest request, @MappingTarget Account account);
}
