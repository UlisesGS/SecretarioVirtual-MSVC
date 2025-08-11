package com.example.service_dailyAvailability.controller;

import com.example.service_dailyAvailability.model.dtos.RequestCreateAvailabilityDto;
import com.example.service_dailyAvailability.model.dtos.ResponseDailyAvailabilityDto;
import com.example.service_dailyAvailability.service.DailyAvailabiltyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/availabilitys")
@RequiredArgsConstructor
public class DailyAvailabilityController {
    private final DailyAvailabiltyService dailyAvailabiltyService;

    @PostMapping("/create")
    public ResponseEntity<ResponseDailyAvailabilityDto>create(@RequestBody RequestCreateAvailabilityDto availabilityDto){
        return new ResponseEntity<>(dailyAvailabiltyService.create(availabilityDto), HttpStatus.OK);
    }

    @GetMapping("/list-all")
    public ResponseEntity<List<ResponseDailyAvailabilityDto>>getAll(){
        return new ResponseEntity<>(dailyAvailabiltyService.getAll(),HttpStatus.OK);
    }
}
