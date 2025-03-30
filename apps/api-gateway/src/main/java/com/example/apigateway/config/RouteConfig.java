package com.example.apigateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RouteConfig {

    @Bean
    public RouteLocator gatewayRoutes(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("user-service", r -> r.path("/users/**")
                        .uri("lb://USER-SERVICE")) // Load-balanced route to User Service
                .route("order-service", r -> r.path("/orders/**")
                        .uri("lb://ORDER-SERVICE")) // Load-balanced route to Order Service
                .build();
    }
}
