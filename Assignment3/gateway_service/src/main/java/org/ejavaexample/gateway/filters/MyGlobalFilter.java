package org.ejavaexample.gateway.filters;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.http.HttpHeaders;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;

import reactor.core.publisher.Mono;

@Component
public class MyGlobalFilter implements GlobalFilter {
    
    final Logger logger = LoggerFactory.getLogger(MyGlobalFilter.class);

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
         
        return chain.filter(exchange).then(Mono.fromRunnable(()-> {
            
            logger.info("Global Post-filter executed...");
			ServerHttpResponse response = exchange.getResponse();
//			HttpHeaders headers = response.getHeaders();
//			headers.forEach((k,v)->{
//				System.out.println(k + " : " + v);
//			});
//
			response.beforeCommit(() -> {
                response.getHeaders().set("GlobalId", "global-id-token");
                return Mono.empty();
            });
        }));
    }
}