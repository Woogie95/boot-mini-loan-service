package com.example.bootloanservice.entity;

import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@Entity(name = "PRODUCT_INFO_TABLE")
public class ProductInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long prod_id;
    private String org_cd;
    private String prod_cd;
    private Double prod_min_intr;
    private Double prod_max_intr;

}
