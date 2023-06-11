package com.jbb.userservice.controller;

import com.jbb.userservice.service.CircuitBreakerTestService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user/circuit-breaker")
public class CircuitBreakerTestController {

    private final CircuitBreakerTestService circuitBreakerTestService;

    @GetMapping("/test")
    public String test() {
        return circuitBreakerTestService.getFail();
    }

}
