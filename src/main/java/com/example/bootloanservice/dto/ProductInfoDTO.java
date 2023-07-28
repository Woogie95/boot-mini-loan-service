package com.example.bootloanservice.dto;

import com.example.bootloanservice.entity.ProductInfo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductInfoDTO {
    private Long productId;
    private String organizationCode;
    private String productCode;
    private String productName;
    private Double productMinimumInterest;
    private Double productMaximumInterest;

    public static ProductInfoDTO from(ProductInfo productInfo) {
        return ProductInfoDTO.builder()
                .productId(productInfo.getProductId())
                .organizationCode(productInfo.getOrganizationCode())
                .productCode(productInfo.getProductCode())
                .productName(productInfo.getProductName())
                .productMinimumInterest(productInfo.getProductMinimumInterest())
                .productMaximumInterest(productInfo.getProductMaximumInterest())
                .build();
    }

}
