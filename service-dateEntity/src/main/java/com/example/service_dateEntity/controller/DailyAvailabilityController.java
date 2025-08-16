package com.example.service_dateEntity.controller;


import com.example.service_dateEntity.model.dtos.*;
import com.example.service_dateEntity.service.DailyAvailabiltyService;
import com.example.service_dateEntity.utils.AllowedForEmployeesAndAdmins;
import com.example.service_dateEntity.utils.AllowedForUsersAndEmployeesAndAdmins;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/availability")
@RequiredArgsConstructor
public class DailyAvailabilityController {
    private final DailyAvailabiltyService dailyAvailabiltyService;

    @AllowedForEmployeesAndAdmins
    @PostMapping("/create")
    public ResponseEntity<ResponseDailyAvailabilityDto>create(@RequestBody @Valid RequestCreateAvailabilityDto availabilityDto){
        return new ResponseEntity<>(dailyAvailabiltyService.create(availabilityDto), HttpStatus.OK);
    }

    @AllowedForUsersAndEmployeesAndAdmins
    @GetMapping("/list-all")
    public ResponseEntity<List<ResponseDailyAvailabilityDto>>getAll(){
        return new ResponseEntity<>(dailyAvailabiltyService.getAll(),HttpStatus.OK);
    }

    @AllowedForUsersAndEmployeesAndAdmins
    @GetMapping("/list-dates")
    public ResponseEntity<List<ResponseDateDto>>findAllByDayAndEmployee
            (@RequestBody @Valid RequestFindAllDatesByEmployeeAndDay request){
        return new ResponseEntity<>(dailyAvailabiltyService.findAllByDayAndEmployee(request),HttpStatus.OK);
    }

    @AllowedForUsersAndEmployeesAndAdmins
    @GetMapping("/list-dates-by-day")
    public ResponseEntity<List<ResponseDateDto>> findAllByDayAndEmployeeAndDate(@RequestBody
                                                                                @Valid RequestFindAllByDayAndEmployeeAndDate request){
        return new ResponseEntity<>(dailyAvailabiltyService.findAllByDayAndEmployeeAndDate(request),HttpStatus.OK);
    }
}
