package com.example.bootloanservice.controller;

import com.example.bootloanservice.dto.CreateProductInfoDTO;
import com.example.bootloanservice.dto.FindByOrganizationCodeProductInfoDTO;
import com.example.bootloanservice.dto.ProductInfoDTO;
import com.example.bootloanservice.dto.UpdateProductInfoDTO;
import com.example.bootloanservice.entity.ProductInfo;
import com.example.bootloanservice.service.ProductInfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

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

    // 특정 코드 정보 조회
    @GetMapping("/{organizationCode}")
    public List<FindByOrganizationCodeProductInfoDTO> findByOrganizationCode(@PathVariable String organizationCode) {
        return productInfoService.findByOrganizationCode(organizationCode);
    }

    @GetMapping("/informations")
    public List<ProductInfoDTO> findAllProductInfos() {
        return productInfoService.findAllProductInfos();
    }

    // 상세조회
    @GetMapping("/detail/{id}")
    public Optional<ProductInfo> findByIdProductInfo(@PathVariable Long id) {
        return productInfoService.findById(id);
    }

    // 수정
    @PutMapping("/{id}")
    public UpdateProductInfoDTO.Response updateProductInfo(
            @PathVariable Long id, @RequestBody UpdateProductInfoDTO.Request updateProductRequest)
            throws ChangeSetPersister.NotFoundException {
        return productInfoService.updateProductInfo(id, updateProductRequest);
    }

    @DeleteMapping("/{id}")
    public boolean deleteProductInfo(@PathVariable Long id) throws ChangeSetPersister.NotFoundException {
        return productInfoService.deleteProductInfo(id);
    }

}
