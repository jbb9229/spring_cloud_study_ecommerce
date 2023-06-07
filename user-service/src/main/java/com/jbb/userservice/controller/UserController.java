package com.jbb.userservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user-service") // api-gateway 에서 routing 될 때 /user-service 라는 prefix 가 붙는다.
public class UserController {

    @GetMapping("/welcome")
    public String welcome() {
        return "Welcome to user-service";
    }

}
