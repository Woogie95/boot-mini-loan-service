package com.example.bootloanservice.entity;

import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@Entity(name = "USER_INFO")
public class UserInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long user_id;
    private String userKey;
    private String userRegistrationNumber;
    private String userName;
    private Long userIncomeAmount;

}