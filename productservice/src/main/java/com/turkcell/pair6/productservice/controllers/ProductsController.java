package com.turkcell.pair6.productservice.controllers;

import com.turkcell.pair6.productservice.entities.Product;
import com.turkcell.pair6.productservice.services.abstracts.ProductService;
import com.turkcell.pair6.productservice.services.dtos.requests.ProductRequest;
import com.turkcell.pair6.productservice.services.dtos.requests.ProductUpdateRequest;
import com.turkcell.pair6.productservice.services.dtos.responses.ProductDetailsResponse;
import com.turkcell.pair6.productservice.services.dtos.responses.ProductResponse;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/products")
@AllArgsConstructor
public class ProductsController {

    private final ProductService productService;
    @GetMapping("/hasProduct")
    boolean hasAccountProduct(@RequestParam("accountId") int accountId)
    {
        return false;
    }

    @GetMapping("/products")
    public List<ProductResponse> getAllProduct(@RequestParam(defaultValue = "0") int pageNumber,
                                        @RequestParam(defaultValue = "10") int pageSize){
        return productService.getAllProductActive(PageRequest.of(pageNumber, pageSize));

    }

    @GetMapping("/productsDetails")
    public List<ProductDetailsResponse> getAllProductDetails(@RequestParam(defaultValue = "0") int pageNumber,
                                               @RequestParam(defaultValue = "10") int pageSize){
        return productService.getAllProductDetails(PageRequest.of(pageNumber, pageSize));

    }

    @PostMapping
    void add(@RequestBody ProductRequest product){
        productService.add(product);

    }

    @PutMapping()
    void update(@RequestBody ProductUpdateRequest product){
        productService.update(product);
    }

    @DeleteMapping()
    public void delete(@RequestParam int id){
        productService.delete(id);
    }



}