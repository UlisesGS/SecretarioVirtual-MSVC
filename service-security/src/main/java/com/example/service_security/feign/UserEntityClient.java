package com.example.service_security.feign;

import com.example.service_security.dto.RequestLoginDto;
import com.example.service_security.dto.ResponseUserEntityDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(value = "gateway", path = "/service-userentity/users")
public interface UserEntityClient {

    @PostMapping("/validate")
    ResponseUserEntityDto validateUser(@RequestBody RequestLoginDto loginRequest);
}
