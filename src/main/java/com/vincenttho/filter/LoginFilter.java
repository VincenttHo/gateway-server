package com.vincenttho.filter;

import feign.FeignException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpHeaders;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.List;

/**
 * @className:com.vincent.filter.LoginFilter
 * @description:
 * @version:v1.0.0
 * @author: VincentHo
 * <p>
 * Modification History:
 * Date         Author      Version     Description
 * -----------------------------------------------------------------
 * 2019/10/14     VincentHo       v1.0.0        create
 */

@Slf4j
@Component
public class LoginFilter implements GlobalFilter, Ordered {

    @Value("login.config.passUrlList")
    private List<String> passUrlList;

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {

        ServerHttpRequest request = exchange.getRequest();
        String path = request.getPath().toString();

        // 可忽略连接
        if(!CollectionUtils.isEmpty(passUrlList)) {
            for(String passUrl : passUrlList) {
                boolean startStar = passUrl.startsWith("**/");
                boolean endStar = passUrl.endsWith("/**");
                if(startStar && endStar && path.contains(passUrl)) {
                    return chain.filter(exchange);
                } else if(startStar && path.endsWith(passUrl)) {
                    return chain.filter(exchange);
                } else if(endStar && path.startsWith(passUrl)) {
                    return chain.filter(exchange);
                }
            }
        }

        HttpHeaders headers = request.getHeaders();
        String accessToken = headers.getFirst("access_token");
        if(accessToken == null) {
            throw new FeignException.Unauthorized("访问异常：无登录令牌", null);
        }

        // TODO 校验token

        return chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        return 1;
    }
}