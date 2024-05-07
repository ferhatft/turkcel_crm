package com.turkcell.pair6.customerservice.clients;

import com.turkcell.core.configuration.feign.FeignClientConfiguration;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name="orderservice", configuration = FeignClientConfiguration.class)
public interface OrderServiceClient {


    @GetMapping("/api/orders/hasProduct")
    boolean hasCustomerProduct(@RequestParam("customerNationalityId") String nationalityId);
}
