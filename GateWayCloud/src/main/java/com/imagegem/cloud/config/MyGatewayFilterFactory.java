package com.imagegem.cloud.config;

import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.factory.AbstractNameValueGatewayFilterFactory;
import org.springframework.cloud.gateway.support.GatewayToStringStyler;
import org.springframework.cloud.gateway.support.ServerWebExchangeUtils;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * @author JXY
 * @version 1.0
 * @since 2024/4/19
 */
@Component
public class MyGatewayFilterFactory extends AbstractNameValueGatewayFilterFactory {
    public MyGatewayFilterFactory() {
    }

    @Override
    public GatewayFilter apply(final AbstractNameValueGatewayFilterFactory.NameValueConfig config) {
        return new GatewayFilter() {
            @Override
            public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
                String userType = ServerWebExchangeUtils.expand(exchange, config.getValue());
                ServerHttpRequest request = exchange.getRequest().mutate().headers((httpHeaders) -> httpHeaders.add(config.getName(), userType)).build();
                return chain.filter(exchange.mutate().request(request).build());
            }

            public String toString() {
                return GatewayToStringStyler.filterToStringCreator(MyGatewayFilterFactory.this).append(config.getName(), config.getValue()).toString();
            }

        };
    }
}
