package com.turkcell.pair6.invoiceservice.clients;

import com.turkcell.core.configuration.feign.FeignClientConfiguration;
import com.turkcell.pair6.invoiceservice.services.dtos.requests.UpdateAddressRequest;
import com.turkcell.pair6.invoiceservice.services.dtos.requests.AddAddressRequest;
import jakarta.validation.Valid;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "customerservice", configuration = FeignClientConfiguration.class)
public interface CustomerServiceClient {

    @PostMapping("/api/addresses")
    int add(@RequestBody @Valid AddAddressRequest request);

    @PutMapping("/api/addresses")
    void update(@RequestBody @Valid UpdateAddressRequest updateAddressRequest);
}
