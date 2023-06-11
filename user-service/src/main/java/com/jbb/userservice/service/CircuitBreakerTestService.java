package com.jbb.userservice.service;

import io.github.resilience4j.bulkhead.annotation.Bulkhead;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class CircuitBreakerTestService {

    private static final String TEST_CIRCUIT_BREAKER = "testCircuitBreaker";

    @Bulkhead(name = TEST_CIRCUIT_BREAKER)
    @CircuitBreaker(name = TEST_CIRCUIT_BREAKER, fallbackMethod = "fallback")
    public String getFail() {
        int randomInt = new Random().nextInt(10);

        if (randomInt <= 7) {
            throw new RuntimeException("failed");
        }

        return "success";
    }

    public String fallback(Throwable t) {
        return String.format("fallback: %s", t.getMessage());
    }

}
