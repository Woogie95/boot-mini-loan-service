package com.example.bootloanservice.dto;

import com.example.bootloanservice.entity.UserInfo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

public class CreateUserInfoDTO {

    @Getter
    @Setter
    @AllArgsConstructor
    @Builder
    public static class Request {

        @NotNull(message = "사용자의 이름을 입력해주세요.")
        private String username;
        @NotNull(message = "주민등록 번호를 입력해주세요.")
        private String userRegistrationNumber;
        @NotNull(message = "초기 설정할 계좌 금액을 입력해주세요.")
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
