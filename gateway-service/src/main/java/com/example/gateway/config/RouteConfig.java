package com.example.gateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RouteConfig {

    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
            .route("auth-service", r -> r.path("/api/v1/auth/**")
                .uri("lb://AUTH-SERVICE"))
            .route("user-service", r -> r.path("/api/v1/users/**")
                .uri("lb://USER-SERVICE"))
            .route("public-event-service", r -> r.path("/api/v1/events/**")
                .uri("lb://PUBLIC-EVENT-SERVICE"))
            .route("booking-service", r -> r.path("/api/v1/bookings/**")
                .uri("lb://BOOKING-SERVICE"))
            .route("ticketing-service", r -> r.path("/api/v1/tickets/**")
                .uri("lb://TICKETING-SERVICE"))
            .build();
    }
}
