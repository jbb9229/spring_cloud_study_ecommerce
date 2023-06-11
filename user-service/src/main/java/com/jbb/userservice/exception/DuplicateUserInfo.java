package com.jbb.userservice.exception;

public class DuplicateUserInfo extends UserServiceException {

    public static final String MESSAGE = "User with email %s already exists";

    public DuplicateUserInfo() {
        super(MESSAGE);
    }

    @Override
    public int getStatusCode() {
        return 409;
    }

}
