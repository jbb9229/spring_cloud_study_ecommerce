package com.example.gatewayservice.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.OrderedGatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.core.Ordered;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
@Slf4j
public class CustomFilter extends AbstractGatewayFilterFactory<CustomFilter.Config> {
    public CustomFilter() {
        super(Config.class);
    }

    @Override
    public GatewayFilter apply(CustomFilter.Config config) {
//        return ((exchange, chain) -> {
//            ServerHttpRequest request = exchange.getRequest();
//            ServerHttpResponse response = exchange.getResponse();
//
//            log.info("Custom PRE filter: request id -> {}", request.getId());
//            return chain.filter(exchange).then(Mono.fromRunnable(() -> {
//                log.info("Custom POST filter: response code -> {}", response.getStatusCode());
//            }));
//        });

//        GatewayFilter filter = new OrderedGatewayFilter((exchange, chain) -> {
//            ServerHttpRequest request = exchange.getRequest();
//            ServerHttpResponse response = exchange.getResponse();
//
//            log.info("Custom PRE filter: request id -> {}", request.getId());
//            return chain.filter(exchange).then(Mono.fromRunnable(() -> {
//                log.info("Custom POST filter: response code -> {}", response.getStatusCode());
//            }));
//        }, Ordered.HIGHEST_PRECEDENCE);

//        return filter;

        return new OrderedGatewayFilter((exchange, chain) -> {
            ServerHttpRequest request = exchange.getRequest();
            ServerHttpResponse response = exchange.getResponse();

            log.info("Custom PRE filter: request id -> {}", request.getId());
            return chain.filter(exchange).then(Mono.fromRunnable(() -> {
                log.info("Custom POST filter: response code -> {}", response.getStatusCode());
            }));
        }, Ordered.HIGHEST_PRECEDENCE);
    }

    public static class Config {
        // Configuration 정보가 필요하면 여기에 추가한다.
    }
}
