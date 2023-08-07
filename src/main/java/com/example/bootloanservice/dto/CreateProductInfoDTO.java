package com.example.bootloanservice.dto;

import com.example.bootloanservice.entity.ProductInfo;
import lombok.*;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class CreateProductInfoDTO {

    @Getter
    @AllArgsConstructor
    @Builder
    public static class Request {

        @NotNull(message = "기관 코드를 입력해주세요.")
        private String organizationCode;
        @NotNull(message = "상품 번호를 입력해주세요.")
        private String productCode;
        @NotNull(message = "상품 이름을 입력해주세요.")
        private String productName;
        @Min(1)
        private Double productMinimumInterest;
        @Max(10)
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
