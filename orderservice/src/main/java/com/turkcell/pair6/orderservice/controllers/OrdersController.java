package com.turkcell.pair6.orderservice.controllers;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/orders")
@RequiredArgsConstructor
public class OrdersController {



    @GetMapping("/hasProduct")
    boolean hasCustomerProduct(@RequestParam("customerNationalityId") String nationalityId)
    {
        return false;
    }


}
