package com.turkcell.pair6.productservice.services.dtos.requests;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductUpdateRequest {
    private int id;
    private String productNo;
    private String name;
    private String campaignName;
    private String campaignId;
    private String action;
    private String offerName;
    private String offerId;
    private String specId;
}
