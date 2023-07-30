package com.example.bootloanservice.service;

import com.example.bootloanservice.config.UniqueKey;
import com.example.bootloanservice.dto.CreateUserInfoDTO;
import com.example.bootloanservice.dto.FindByOrganizationCodeProductInfoDTO;
import com.example.bootloanservice.entity.ProductInfo;
import com.example.bootloanservice.entity.UserInfo;
import com.example.bootloanservice.repository.UserInfoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserInfoService {

    private final UserInfoRepository userInfoRepository;

    @Transactional
    public String createUserInfo(CreateUserInfoDTO.Request createUserInfoDTO) {
        String userKey = UniqueKey.generateUniqueKey();

        CreateUserInfoDTO.Response response = CreateUserInfoDTO.Response.builder()
                .userKey(userKey)
                .build();

        UserInfo userInfo = createUserInfoDTO.toEntity();
        userInfo.setUserKey(response.getUserKey());

        userInfoRepository.save(userInfo);

        return CreateUserInfoDTO.Response.from(userInfo).getUserKey();
    }

    @Transactional(readOnly = true)
    public ResponseEntity<?> findByUserKey(String userKey) {

    }
}
    @Transactional(readOnly = true)
    public List<FindByOrganizationCodeProductInfoDTO> findByOrganizationCode(String organizationCode) {
        List<ProductInfo> productInfos = productInfoRepository.findByOrganizationCode(organizationCode);

        return productInfos.stream()
                .map(FindByOrganizationCodeProductInfoDTO::from)
                .collect(Collectors.toList());
    }