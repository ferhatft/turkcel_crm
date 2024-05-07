package com.turkcell.pair6.invoiceservice.controllers;

import com.turkcell.pair6.invoiceservice.services.abstracts.AccountService;
import com.turkcell.pair6.invoiceservice.services.dtos.requests.AddBillingRequest;
import com.turkcell.pair6.invoiceservice.services.dtos.requests.UpdateAccountRequest;
import com.turkcell.pair6.invoiceservice.services.dtos.responses.AccountResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/accounts")
@AllArgsConstructor
public class AccountController {
    private final AccountService accountService;

    @GetMapping
    public List<AccountResponse> getAll(@RequestParam(defaultValue = "0") int pageNumber,
                                        @RequestParam(defaultValue = "10") int pageSize) {
        return accountService.findAllByIsActiveTrue(PageRequest.of(pageNumber, pageSize));
    }

    @PostMapping
    public void add(@RequestBody @Valid AddBillingRequest request)
    {
        accountService.add(request);
    }

    @DeleteMapping
    public String delete(int id){
        return accountService.delete(id);
    }

    @PutMapping
    public void update(@RequestBody @Valid UpdateAccountRequest updateAccountRequest) {
        accountService.update(updateAccountRequest);
    }
}
