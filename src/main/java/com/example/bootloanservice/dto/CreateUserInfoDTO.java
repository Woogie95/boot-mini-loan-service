package com.example.bootloanservice.dto;

import com.example.bootloanservice.entity.UserInfo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

public class CreateUserInfoDTO {

    @Getter
    @Setter
    @AllArgsConstructor
    @Builder
    public static class Request {

        private String username;
        private String userRegistrationNumber;
        private Long userIncomeAmount;

        public UserInfo toEntity() {
            return UserInfo.builder()
                    .username(this.username)
                    .userRegistrationNumber(this.userRegistrationNumber)
                    .userIncomeAmount(this.userIncomeAmount)
                    .build();
        }

    }

    @Getter
    @Setter
    @AllArgsConstructor
    @Builder
    public static class Response {

        private String userKey;

        public static Response from(UserInfo userInfo) {
            return new Response(
                    userInfo.getUserKey());
        }
    }

}
