package com.jbb.userservice.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class SignUp {

    @NotBlank
    @Size(min = 2)
    @Email
    private String email;

    @NotBlank
    @Size(min = 8)
    private String password;

    @NotBlank
    @Size(min = 2)
    private String name;

    @Builder
    public SignUp(String email, String password, String name) {
        this.email = email;
        this.password = password;
        this.name = name;
    }

}
