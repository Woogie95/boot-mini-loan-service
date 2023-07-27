package com.example.bootloanservice.controller;

import com.example.bootloanservice.dto.CreateProductInfoDTO;
import com.example.bootloanservice.service.ProductInfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/fintech/v1/product")
public class ProductInfoController {

    private final ProductInfoService productInfoService;

    // 등록
    @PostMapping("/information")
    public CreateProductInfoDTO.Response createProductInfo(@RequestBody @Valid CreateProductInfoDTO.Request
                                                                   createProductInfoDTO) {
        return productInfoService.createProductInfo(createProductInfoDTO);
    }

}
