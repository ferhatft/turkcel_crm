package com.turkcell.pair6.invoiceservice.services.rules;

import com.turkcell.core.exceptions.types.BusinessException;
import com.turkcell.core.service.abstracts.MessageService;
import com.turkcell.core.service.constants.Messages;
import com.turkcell.pair6.invoiceservice.clients.ProductServiceClient;
import com.turkcell.pair6.invoiceservice.entities.Account;
import com.turkcell.pair6.invoiceservice.repositories.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Optional;

@RequiredArgsConstructor
@Component
public class AccountBusinessRules {
    private final ProductServiceClient productServiceClient;
    private final MessageService messageService;
    private final AccountRepository accountRepository;

    public void hasAccountProduct(int id) {
        if (productServiceClient.hasAccountProduct(id)) {
            throw new BusinessException(messageService.getMessage(Messages.BusinessErrors.ACCOUNT_HAS_PRODUCT));
        }
    }

    public void isAccountIdExist(int id){

        Account account = accountRepository.findActiveAccountById(id).orElse(null);


        if (account == null)
            throw new BusinessException(messageService.getMessage(Messages.BusinessErrors.ACCOUNT_DOES_NOT_EXIST));

    }

}
