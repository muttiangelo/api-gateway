package com.mutti.apigateway.configuration;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApiGatewayConfiguration {

    @Bean
    public RouteLocator gatewayRouter(RouteLocatorBuilder builder) {
        return builder.routes()
                .route(p -> p.path("/get")
                        .filters(f -> f.
                                addRequestHeader("headerj", "4fjdshfisfs").
                                addRequestHeader("otherheader", "teanifa"))
                        .uri("http://httpbin.org:80"))
                .route(p -> p
                        .path("/currency-exchange/**")
                        .uri("lb://exchange-service"))
                .route(p -> p
                        .path("/currency-conversion/**")
                        .uri("lb://currency-conversion"))
                .build();
    }
}
