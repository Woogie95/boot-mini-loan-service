package com.example.bootloanservice.dto;

import com.example.bootloanservice.entity.UserInfo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class FindByUserKeyUserInfoDTO {

    private String userKey;
    private String userRegistrationNumber;

    public static FindByUserKeyUserInfoDTO from(UserInfo userInfo) {
        return FindByUserKeyUserInfoDTO.builder()
                .userKey(userInfo.getUserKey())
                .userRegistrationNumber(userInfo.getUserRegistrationNumber())
                .build();
    }

}
