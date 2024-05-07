package com.turkcell.pair6.invoiceservice.clients;

import com.turkcell.core.configuration.feign.FeignClientConfiguration;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "productservice", configuration = FeignClientConfiguration.class)
public interface ProductServiceClient {
    @GetMapping("/api/products/hasProduct")
    boolean hasAccountProduct(@RequestParam("accountId") int accountId);
}
