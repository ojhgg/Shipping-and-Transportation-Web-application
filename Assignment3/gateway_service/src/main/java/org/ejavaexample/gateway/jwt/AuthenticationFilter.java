package org.ejavaexample.gateway.jwt;

import org.ejavaexample.gateway.filters.MyGlobalFilter;
import org.ejavaexample.gateway.jwt.payload.request.ValidJwtRequest;
import org.ejavaexample.gateway.jwt.payload.response.MessageResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;

import reactor.core.publisher.Mono;

@RefreshScope
@Component
public class AuthenticationFilter implements GlobalFilter {
    final Logger logger = LoggerFactory.getLogger(AuthenticationFilter.class);

    @Autowired
    private RouterValidator routerValidator;   //custom route validator

    //@Autowired
    //private MessageResponse rspmsg;
 
    //@Autowired
    //private ValidJwtRequest rqtmsg;
    
    @Autowired
	private AuthFeignClient authJwt;

    
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        ServerHttpRequest request = exchange.getRequest();

        if (routerValidator.isSecured.test(request)) {
            if (this.isAuthMissing(request))
                return this.onError(exchange, "Authorization header is missing in request", HttpStatus.UNAUTHORIZED);

            final String token = this.getAuthHeader(request).split(" ")[1];
            ValidJwtRequest rqtmsg=new ValidJwtRequest();
            MessageResponse rspmsg = new MessageResponse();
            
            rqtmsg.setJwt(token); 
            
           rspmsg=authJwt.IsJwtOk(rqtmsg);
           if (rspmsg.getMessage()!="True")
                return this.onError(exchange, "Authorization header is invalid", HttpStatus.UNAUTHORIZED);

           this.populateRequestWithHeaders(exchange, token);
        }
        return chain.filter(exchange);
    }


    /*PRIVATE*/

    private Mono<Void> onError(ServerWebExchange exchange, String err, HttpStatus httpStatus) {
        ServerHttpResponse response = exchange.getResponse();
        response.setStatusCode(httpStatus);
        return response.setComplete();
    }

    private String getAuthHeader(ServerHttpRequest request) {
        return request.getHeaders().getOrEmpty("Authorization").get(0);
    }

    private boolean isAuthMissing(ServerHttpRequest request) {
        return !request.getHeaders().containsKey("Authorization");
    }

    private void populateRequestWithHeaders(ServerWebExchange exchange, String token) {
        //Claims claims = jwtUtil.getAllClaimsFromToken(token);
        exchange.getRequest().mutate()
                .header("id", String.valueOf("id"))
                .header("role", String.valueOf("role"))
                .build();
    }
}