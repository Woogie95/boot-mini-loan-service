package com.example.bootloanservice.config;

import java.util.UUID;

public class UniqueKey {

    public static String generateUniqueKey() {
        UUID uuid = UUID.randomUUID();
        return uuid.toString().replace("-", "");
    }

}
