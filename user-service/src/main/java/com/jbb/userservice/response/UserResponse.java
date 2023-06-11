package com.jbb.userservice.response;

import lombok.Builder;
import lombok.Getter;

@Getter
public class UserResponse {

    private final String userId;
    private final String email;
    private final String name;

    @Builder
    public UserResponse(String userId, String email, String name) {
        this.userId = userId;
        this.email = email;
        this.name = name;
    }

}
