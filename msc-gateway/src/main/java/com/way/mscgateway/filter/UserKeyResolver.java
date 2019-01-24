package com.way.mscgateway.filter;

import org.springframework.cloud.gateway.filter.ratelimit.KeyResolver;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * @Auther: Way Liang
 * @Date: 1/24/2019 17:38
 * @Description:
 */
public class UserKeyResolver implements KeyResolver {


    /**
     * 可以以用户的维度去限流：
     * @param exchange
     * @return
     */
    @Override
    public Mono<String> resolve(ServerWebExchange exchange) {
        return Mono.just(exchange.getRequest().getQueryParams().getFirst("user"));
    }
}
