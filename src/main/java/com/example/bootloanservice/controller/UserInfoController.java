package com.example.bootloanservice.controller;

import com.example.bootloanservice.dto.CreateUserInfoDTO;
import com.example.bootloanservice.dto.FindByUserKeyUserInfoDTO;
import com.example.bootloanservice.service.UserInfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/fintech/v1/user")
public class UserInfoController {

    private final UserInfoService userInfoService;

    @PostMapping("/information")
    public ResponseEntity<Map<String, String>> createUserInfo(@RequestBody @Valid CreateUserInfoDTO.Request
                                                                      createUserInfoDTO) {
        String userKey = userInfoService.createUserInfo(createUserInfoDTO);

        Map<String, String> response = new HashMap<>();
        response.put("userKey", userKey);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/private-info/{userKey}")
    public FindByUserKeyUserInfoDTO findByUserKey(@PathVariable String userKey) {
        return userInfoService.findByUserKey(userKey);
    }

}
