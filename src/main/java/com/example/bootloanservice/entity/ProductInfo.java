package com.example.bootloanservice.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity(name = "PRODUCT_INFO_TABLE")
public class ProductInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productId;
    private String organizationCode;
    private String productCode;
    private String productName;
    private Double productMinimumInterest;
    private Double productMaximumInterest;

}