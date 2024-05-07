package com.turkcell.pair6.productservice.services.dtos.responses;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductResponse {
    private String productNo;
    private String name;
    private String campaignName;
    private String campaignId;
    private String action;
}
