package com.turkcell.pair6.productservice.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.turkcell.core.entities.BaseEntity;

@Entity
@Data
@Table(name = "products")
@AllArgsConstructor
@NoArgsConstructor
public class Product extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "product_no")
    private String productNo;

    @Column(name = "name")
    private String name;

    @Column(name = "campaign_name")
    private String campaignName;

    @Column(name = "campaign_id")
    private String campaignId;

    @Column(name = "action")
    private String action;

    @Column(name = "offer_name")
    private String offerName;

    @Column(name = "offer_id")
    private String offerId;

    @Column(name = "spec_id")
    private String specId;
}
