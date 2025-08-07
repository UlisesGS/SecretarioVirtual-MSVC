package com.example.service_dateEntity.controller;

import com.example.service_dateEntity.model.dtos.RequestCreateDateDto;
import com.example.service_dateEntity.model.dtos.ResponseDateDto;
import com.example.service_dateEntity.service.DateService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dates")
@RequiredArgsConstructor
public class DateController {
    private final DateService dateService;

    @PostMapping("/create-date")
    public ResponseEntity<ResponseDateDto>createDate(@RequestBody @Valid RequestCreateDateDto createDateDto){
        return new ResponseEntity<>(dateService.createDate(createDateDto), HttpStatus.OK);
    }

    @GetMapping("/list-all")
    public ResponseEntity<List<ResponseDateDto>>listAll(){
        return new ResponseEntity<>(dateService.getAll(),HttpStatus.OK);
    }
}
