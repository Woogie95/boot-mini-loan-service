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
public class FindByOrganizationCodeProductInfoDTO {
    private String organizationCode;
    private String productCode;
    private String productName;
    private Double productMinimumInterest;
    private Double productMaximumInterest;

    public static FindByOrganizationCodeProductInfoDTO from(ProductInfo productInfo) {
        return FindByOrganizationCodeProductInfoDTO.builder()
                .organizationCode(productInfo.getOrganizationCode())
                .productCode(productInfo.getProductCode())
                .productName(productInfo.getProductName())
                .productMinimumInterest(productInfo.getProductMinimumInterest())
                .productMaximumInterest(productInfo.getProductMaximumInterest())
                .build();
    }

}
