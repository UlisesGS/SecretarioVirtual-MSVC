package com.example.service_security.feign;

import com.example.service_security.dto.ResponseUserEntityDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "gateway", path = "/users")
public interface UserEntityClient {

    @GetMapping("/credentials/{email}")
    ResponseUserEntityDto getByEmail(@PathVariable String email);
}
