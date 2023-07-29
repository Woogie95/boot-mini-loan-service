package com.example.bootloanservice.service;

import com.example.bootloanservice.config.UniqueKey;
import com.example.bootloanservice.dto.CreateUserInfoDTO;
import com.example.bootloanservice.entity.UserInfo;
import com.example.bootloanservice.repository.UserInfoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserInfoService {

    private final UserInfoRepository userInfoRepository;

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

}
