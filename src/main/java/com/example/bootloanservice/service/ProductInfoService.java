package com.example.bootloanservice.service;

import com.example.bootloanservice.dto.CreateProductInfoDTO;
import com.example.bootloanservice.dto.FindByOrganizationCodeProductInfoDTO;
import com.example.bootloanservice.dto.ProductInfoDTO;
import com.example.bootloanservice.dto.UpdateProductInfoDTO;
import com.example.bootloanservice.entity.ProductInfo;
import com.example.bootloanservice.repository.ProductInfoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductInfoService {

    private final ProductInfoRepository productInfoRepository;

    @Transactional
    public CreateProductInfoDTO.Response createProductInfo(CreateProductInfoDTO.Request createRequest) {
        return CreateProductInfoDTO.Response.from(productInfoRepository.save(createRequest.toEntity()));
    }

    // 전체 조회
    @Transactional(readOnly = true)
    public List<ProductInfoDTO> findAllProductInfos() {
        List<ProductInfo> productInfos = productInfoRepository.findAll();
        return productInfos.stream()
                .map(ProductInfoDTO::from)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public List<FindByOrganizationCodeProductInfoDTO> findByOrganizationCode(String organizationCode) {
        List<ProductInfo> productInfos = productInfoRepository.findByOrganizationCode(organizationCode);

        return productInfos.stream()
                .map(FindByOrganizationCodeProductInfoDTO::from)
                .collect(Collectors.toList());
    }

    // 상세 조회
    @Transactional(readOnly = true)
    public Optional<ProductInfo> findById(Long id) {
        return productInfoRepository.findById(id);
    }

    @Transactional
    public UpdateProductInfoDTO.Response updateProductInfo(Long id, UpdateProductInfoDTO.Request updateProductInfoDTO)
            throws ChangeSetPersister.NotFoundException {
        ProductInfo productInfo = productInfoRepository.findById(id)
                .orElseThrow(ChangeSetPersister.NotFoundException::new);

        String organizationCode = updateProductInfoDTO.getOrganizationCode();
        if (organizationCode != null) {
            productInfo.setOrganizationCode(organizationCode);
        }

        String productCode = updateProductInfoDTO.getProductCode();
        if (productCode != null) {
            productInfo.setProductCode(productCode);
        }

        String productName = updateProductInfoDTO.getProductName();
        if (productName != null) {
            productInfo.setProductName(productName);
        }

        Double productMinimumInterest = updateProductInfoDTO.getProductMinimumInterest();
        if (productMinimumInterest != null) {
            productInfo.setProductMinimumInterest(productMinimumInterest);
        }

        Double productMaximumInterest = updateProductInfoDTO.getProductMaximumInterest();
        if (productMaximumInterest != null) {
            productInfo.setProductMaximumInterest(productMaximumInterest);
        }

        return UpdateProductInfoDTO.Response.from(productInfo);
    }

    @Transactional
    public boolean deleteProductInfo(Long id) throws ChangeSetPersister.NotFoundException {
        ProductInfo productInfo = productInfoRepository.findById(id).orElseThrow(ChangeSetPersister.NotFoundException::new);
        productInfoRepository.delete(productInfo);
        return true;
    }

//    private ProductInfo getOrganizationCode(String organizationCode) {
//        return productInfoRepository.findByOrganizationCode(organizationCode)
//                .orElseThrow(() -> new RuntimeException("조회된 정보가 없습니다."));
//    }

}

