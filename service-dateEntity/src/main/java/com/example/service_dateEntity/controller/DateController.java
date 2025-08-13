package com.example.service_dateEntity.controller;

import com.example.service_dateEntity.model.dtos.RequestCreateAvailabilityDto;
import com.example.service_dateEntity.model.dtos.RequestCreateDateDto;
import com.example.service_dateEntity.model.dtos.ResponseDailyAvailabilityDto;
import com.example.service_dateEntity.model.dtos.ResponseDateDto;
import com.example.service_dateEntity.service.DailyAvailabiltyService;
import com.example.service_dateEntity.service.DateService;
import com.example.service_dateEntity.utils.AllowedForUsersAndAdmins;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dates")
@RequiredArgsConstructor
public class DateController {
    private final DateService dateService;
    private final DailyAvailabiltyService dailyAvailabiltyService;

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/create-date")
    public ResponseEntity<ResponseDateDto>createDate(@RequestBody @Valid RequestCreateDateDto createDateDto){
        return new ResponseEntity<>(dateService.createDate(createDateDto), HttpStatus.OK);
    }

    @AllowedForUsersAndAdmins
    @GetMapping("/list-all")
    public ResponseEntity<List<ResponseDateDto>>listAll(){
        return new ResponseEntity<>(dateService.getAll(),HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/create")
    public ResponseEntity<ResponseDailyAvailabilityDto>create(@RequestBody RequestCreateAvailabilityDto availabilityDto){
        return new ResponseEntity<>(dailyAvailabiltyService.create(availabilityDto), HttpStatus.OK);
    }

    @AllowedForUsersAndAdmins
    @GetMapping("/list-all-dailys")
    public ResponseEntity<List<ResponseDailyAvailabilityDto>>getAll(){
        return new ResponseEntity<>(dailyAvailabiltyService.getAll(),HttpStatus.OK);
    }
}
