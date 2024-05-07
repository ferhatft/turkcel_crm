package com.turkcell.pair6.invoiceservice.services.abstracts;

import com.turkcell.pair6.invoiceservice.services.dtos.requests.AddBillingRequest;
import com.turkcell.pair6.invoiceservice.services.dtos.requests.UpdateAccountRequest;
import com.turkcell.pair6.invoiceservice.services.dtos.responses.AccountResponse;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface AccountService {
    List<AccountResponse> findAllByIsActiveTrue(Pageable pageable);

    void add(AddBillingRequest request);

    String delete(int id);

    void update(UpdateAccountRequest updateAccountRequest);
}
