package com.turkcell.pair6.productservice.services.abstracts;

import com.turkcell.pair6.productservice.entities.Product;
import com.turkcell.pair6.productservice.services.dtos.requests.ProductRequest;
import com.turkcell.pair6.productservice.services.dtos.requests.ProductUpdateRequest;
import com.turkcell.pair6.productservice.services.dtos.responses.ProductDetailsResponse;
import com.turkcell.pair6.productservice.services.dtos.responses.ProductResponse;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProductService {
    List<ProductResponse> getAllProductActive(Pageable pageable);
    List<ProductDetailsResponse> getAllProductDetails(Pageable pageable);

    void add(ProductRequest product);

    void delete(int id);

    void update(ProductUpdateRequest product);
}
