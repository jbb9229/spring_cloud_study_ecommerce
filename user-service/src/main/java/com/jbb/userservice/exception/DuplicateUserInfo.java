package com.jbb.userservice.exception;

import com.jbb.userservice.domain.User;
import com.jbb.userservice.response.UserResponse;

public class DuplicateUserInfo extends UserServiceException {

    public static final String MESSAGE = "이미 가입된 계정 정보입니다.";

    public DuplicateUserInfo() {
        super(MESSAGE);
    }

    public DuplicateUserInfo(User user) {
        super(MESSAGE);
        addValidation("email", user.getEmail());
    }

    @Override
    public int getStatusCode() {
        return 409;
    }

}
