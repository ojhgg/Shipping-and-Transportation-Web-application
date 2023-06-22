package org.ejavaexample.gateway.jwt;

import org.ejavaexample.gateway.jwt.payload.request.ValidJwtRequest;
import org.ejavaexample.gateway.jwt.payload.response.MessageResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;

//@FeignClient(url = "http://localhost:8082/api/user/", name = "UserInformationService")
@FeignClient("AUTH-SERVICE")
public interface AuthFeignClient {

    @PostMapping("/api/auth/isjwtok")
    MessageResponse IsJwtOk(ValidJwtRequest rq);

}
