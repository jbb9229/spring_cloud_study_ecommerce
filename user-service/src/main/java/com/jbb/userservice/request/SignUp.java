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

    @NotBlank(message = "Email cannot be null")
    @Size(min = 2, message = "Email not be less than two characters")
    @Email
    private String email;

    @NotBlank(message = "Password cannot be null")
    @Size(min = 8, message = "Password must be equals or grater than 8 characters")
    private String password;

    @NotBlank(message = "Name cannot be null")
    @Size(min = 2, message = "Name not be less than two characters")
    private String name;

    @Builder
    public SignUp(String email, String password, String name) {
        this.email = email;
        this.password = password;
        this.name = name;
    }

}
