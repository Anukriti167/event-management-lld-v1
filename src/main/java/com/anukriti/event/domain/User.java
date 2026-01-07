package com.anukriti.event.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
public class User {
    private final String userId;
    private final String name;
    private final String email;

    public User(String userId, String name, String email){
        if (userId == null || email == null){
            throw new IllegalArgumentException("User Name and Email cannot be null");
        }
        this.userId = userId;
        this.name = name;
        this.email = email;
    }

    public String getUserId() {
        return userId;
    }
}
