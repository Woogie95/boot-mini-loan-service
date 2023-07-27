package com.example.bootloanservice.service;

import com.example.bootloanservice.dto.CreateProductInfoDTO;
import com.example.bootloanservice.entity.ProductInfo;
import com.example.bootloanservice.repository.ProductInfoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ProductInfoService {

    private final ProductInfoRepository productInfoRepository;

    @Transactional
    public CreateProductInfoDTO.Response createProductInfo(CreateProductInfoDTO.Request createRequest) {
        return CreateProductInfoDTO.Response.from(productInfoRepository.save(ProductInfo.builder()
                .productId(createRequest.getProductId())
                .organizationCode(createRequest.getOrganizationCode())
                .productCode(createRequest.getProductCode())
                .productName(createRequest.getProductName())
                .productMinimumInterest(createRequest.getProductMinimumInterest())
                .productMaximumInterest(createRequest.getProductMaximumInterest())
                .build()));
    }

}
