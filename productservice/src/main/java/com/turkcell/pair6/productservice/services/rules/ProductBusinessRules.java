package com.turkcell.pair6.productservice.services.rules;

import com.turkcell.core.exceptions.types.BusinessException;
import com.turkcell.core.service.abstracts.MessageService;
import com.turkcell.core.service.constants.Messages;
import com.turkcell.pair6.productservice.entities.Product;
import com.turkcell.pair6.productservice.repositories.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;



@Component
@RequiredArgsConstructor
public class ProductBusinessRules {
    private final ProductRepository productRepository;
    private final MessageService messageService;

    public void isProductIdExist(int id){

        Product product = productRepository.findByIdAndIsActiveTrue(id).orElse(null);


        if (product == null)
            throw new BusinessException(messageService.getMessage(Messages.BusinessErrors.PRODUCT_DOES_NOT_EXIST));

    }

    public void isProductExistWithProductNo(String productNo){
        Product product = productRepository.findActiveByProductNo(productNo).orElse(null);

        if(product != null){
            throw new BusinessException(messageService.getMessage(Messages.BusinessErrors.PRODUCT_WITH_THIS_PRODUCTNO_ALREADY_EXIST));
        }
    }
}
