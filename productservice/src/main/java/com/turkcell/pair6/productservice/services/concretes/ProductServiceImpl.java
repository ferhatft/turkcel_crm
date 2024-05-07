package com.turkcell.pair6.productservice.services.concretes;

import com.turkcell.pair6.productservice.entities.Product;
import com.turkcell.pair6.productservice.repositories.ProductRepository;
import com.turkcell.pair6.productservice.services.abstracts.ProductService;
import com.turkcell.pair6.productservice.services.dtos.requests.ProductRequest;
import com.turkcell.pair6.productservice.services.dtos.requests.ProductUpdateRequest;
import com.turkcell.pair6.productservice.services.dtos.responses.ProductDetailsResponse;
import com.turkcell.pair6.productservice.services.dtos.responses.ProductResponse;
import com.turkcell.pair6.productservice.services.mappers.ProductMapper;
import com.turkcell.pair6.productservice.services.rules.ProductBusinessRules;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final ProductBusinessRules productBusinessRules;

    @Override
    public List<ProductResponse> getAllProductActive(Pageable pageable) {
        Page<Product> products = productRepository.findAllByIsActiveTrue(pageable);
        return products.map(ProductMapper.INSTANCE::responseFromProduct).getContent();
    }

    @Override
    public List<ProductDetailsResponse> getAllProductDetails(Pageable pageable) {
        Page<Product> products = productRepository.findAllByIsActiveTrue(pageable);
        return products.map(ProductMapper.INSTANCE::detailsResponseFromProduct).getContent();
    }

    @Override
    public void add(ProductRequest productRequest) {
        productBusinessRules.isProductExistWithProductNo(productRequest.getProductNo());

        Product product = ProductMapper.INSTANCE.productFromAddRequest(productRequest);
        productRepository.save(product);
    }

    @Override
    public void delete(int id) {
        productBusinessRules.isProductIdExist(id);

        productRepository.deactivateByProductNo(id);
    }

    @Override
    public void update(ProductUpdateRequest productRequest) {
        productBusinessRules.isProductIdExist(productRequest.getId());

        Product product = productRepository.findByIdAndIsActiveTrue(productRequest.getId()).orElse(null);

        Product updatedProduct = ProductMapper.INSTANCE.productFromUpdateRequest(productRequest,product);
        productRepository.save(updatedProduct);
    }
}
