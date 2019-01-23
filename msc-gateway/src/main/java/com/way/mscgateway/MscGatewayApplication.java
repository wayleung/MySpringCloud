package com.way.mscgateway;

import com.way.mscgateway.filter.RequestTimeFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@SpringBootApplication
@RestController

public class MscGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(MscGatewayApplication.class, args);
    }


//    @Bean
//    public RouteLocator myRoutes(RouteLocatorBuilder builder){
//        String httpUri = "http://httpbin.org:80";
//
//        return builder.routes()
//                .route(p->p
//                .path("/get")
//                .filters(f->f.addRequestHeader("Hello","World"))
////                .uri("http://localhost:8761"))
//                .uri(httpUri))
//
//                /**
//                 * 当我们向gateway工程请求“/get”,
//                 * gateway会将工程的请求转发到“http://httpbin.org/get”，
//                 * 并且在转发之前，加上一个filter，
//                 * 该filter会将请求添加一个header,
//                 * key为hello，value为world。
//                 */
//
//                .route(p -> p
//                        .host("*.hystrix.com")
//                        .filters(f -> f
//                                .hystrix(config -> config
//                                        .setName("mycmd")
//                                        .setFallbackUri("forward:/fallback")))
//                        .uri(httpUri))
//                .build();
//
//        /**
//         *在上面的代码中，我们使用了另外一个router，
//         * 该router使用host去断言请求是否进入该路由，
//         * 当请求的host有“*.hystrix.com”，都会进入该router，
//         * 该router中有一个hystrix的filter,该filter可以配置名称、和指向性fallback的逻辑的地址，
//         * 比如本案例中重定向到了“/fallback”
//         */
//
//
//
//    }

    @Bean
    public RouteLocator customerRouteLocator(RouteLocatorBuilder builder){

        return builder.routes()
                .route(r->r.path("/customer/**")
                        .filters(f->f.filter(new RequestTimeFilter())
                        .addRequestHeader("X-Response-Default-Foo", "Default-Bar"))
                        .uri("http://httpbin.org:80/get")
                        .order(0)
                        .id("customer_filter_router")
                ).build();
    }


    @RequestMapping("/fallback")
    public Mono<String> fallback() {
        return Mono.just("fallback");
    }

}

