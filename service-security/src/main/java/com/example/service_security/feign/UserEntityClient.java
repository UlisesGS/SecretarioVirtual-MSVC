package com.example.service_security.feign;


import com.example.service_security.dto.ResponseCredentialsDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "service-userEntity", path = "/users")
public interface UserEntityClient {

    @GetMapping("/credentials/{email}")
    ResponseCredentialsDto getByEmail(@PathVariable String email);
}
