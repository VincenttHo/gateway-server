package com.vincent.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Slf4j
@Component
public class LogFilter implements GlobalFilter, Ordered {
    /**
    * 执行逻辑
    * @Title:
    * @Description: 执行逻辑
    * @author: VincentHo
    * @date 2019/10/17
    * @version 1.0
    */
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        ServerHttpRequest request = exchange.getRequest();
        //打印每次请求的url
        log.info("请求地址：{}", request.getURI());
        log.info("请求地址：{}", request.getPath());
        log.info("请求头：{}", request.getHeaders());
        return chain.filter(exchange);
    }

    /**
     * 执行逻辑
     * @Title:
     * @Description: 执行顺序
     * @author: VincentHo
     * @date 2019/10/17
     * @version 1.0
     */
    @Override
    public int getOrder() {
        return 0;
    }
}