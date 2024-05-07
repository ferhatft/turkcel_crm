package com.turkcell.pair6.productservice.services.dtos.requests;

import jakarta.persistence.Column;
import lombok.*;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductRequest {
    private String productNo;
    private String name;
    private String campaignName;
    private String campaignId;
    private String action;
    private String offerName;
    private String offerId;
    private String specId;
}
