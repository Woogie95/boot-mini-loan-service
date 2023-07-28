package com.example.bootloanservice.repository;

import com.example.bootloanservice.entity.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<UserInfo, Long> {

}
