package com.jbb.userservice.controller;

import com.jbb.userservice.request.SignUp;
import com.jbb.userservice.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
@Slf4j
public class UserController {

    private final Environment environment;
    private final UserService userService;

    @GetMapping("/health_check")
    public String status() {
        return "It's Working in User Service";
    }

    @GetMapping("/welcome")
    public String welcome() {
        return environment.getProperty("greeting.message");
    }

    @PostMapping("/signup")
    public HttpStatus signup(@Valid @RequestBody SignUp signUp) {
        userService.signUp(signUp);

        return HttpStatus.CREATED;
    }

}
