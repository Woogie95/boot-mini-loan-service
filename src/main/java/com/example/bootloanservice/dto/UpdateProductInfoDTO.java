package com.example.bootloanservice.dto;

import com.example.bootloanservice.entity.ProductInfo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

public class UpdateProductInfoDTO {

    @Getter
    @AllArgsConstructor
    @Builder
    public static class Request {

        private String organizationCode;
        private String productCode;
        private String productName;
        private Double productMinimumInterest;
        private Double productMaximumInterest;

        public ProductInfo toEntity() {
            return ProductInfo.builder()
                    .organizationCode(this.organizationCode)
                    .productCode(this.productCode)
                    .productName(this.productName)
                    .productMinimumInterest(this.productMinimumInterest)
                    .productMaximumInterest(this.productMaximumInterest)
                    .build();
        }
    }

    @Getter
    @AllArgsConstructor
    @Builder
    public static class Response {
        private Long id;
        private String organizationCode;
        private String productCode;
        private String productName;
        private Double productMinimumInterest;
        private Double productMaximumInterest;

        public static Response from(ProductInfo productInfo) {
            return new Response(
                    productInfo.getProductId(),
                    productInfo.getOrganizationCode(),
                    productInfo.getProductCode(),
                    productInfo.getProductName(),
                    productInfo.getProductMinimumInterest(),
                    productInfo.getProductMaximumInterest());
        }
    }

}