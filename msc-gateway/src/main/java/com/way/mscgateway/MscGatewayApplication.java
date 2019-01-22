package com.way.mscgateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class MscGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(MscGatewayApplication.class, args);
    }


    public RouteLocator myRoutes(RouteLocatorBuilder builder){
        return builder.routes().route(p->p
                .path("/get")
                .filters(f->f.addRequestHeader("Hello","World"))
                .uri("http://httpbin.org:80"))
                .build();
    }

}

