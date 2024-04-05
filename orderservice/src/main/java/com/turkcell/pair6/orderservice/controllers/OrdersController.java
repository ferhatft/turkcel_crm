package com.turkcell.pair6.orderservice.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/orders")
public class OrdersController {

    /*
    @GetMapping
    public int getCustomerIdByOrderId(@RequestParam String orderId){
        //TODO: Mongodb'e gidip query ile çek.
        return 10;
    }
    */

    @GetMapping("/hasProduct")
    boolean hasCustomerProduct(@RequestParam("customerNationalityId") String nationalityId)
    {
        return false;
    }
}
