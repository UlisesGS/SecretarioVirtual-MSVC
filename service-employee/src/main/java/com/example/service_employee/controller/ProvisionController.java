package com.example.service_employee.controller;

import com.example.service_employee.model.dtos.RequestCreateProvisionDto;
import com.example.service_employee.model.dtos.ResponseProvisionDto;
import com.example.service_employee.service.ProvisionService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/provisions")
@RequiredArgsConstructor
public class ProvisionController {
    private final ProvisionService provisionService;

    @PostMapping("/create-provision")
    public ResponseEntity<ResponseProvisionDto>createProvision(@RequestBody @Valid
                                                               RequestCreateProvisionDto provisionDto){
        return new ResponseEntity<>(provisionService.createProvision(provisionDto), HttpStatus.OK);
    }

    @GetMapping("/list-all-provision")
    public ResponseEntity<List<ResponseProvisionDto>>getAllProvisions(){
        return new ResponseEntity<>(provisionService.getAll(),HttpStatus.OK);
    }


}
