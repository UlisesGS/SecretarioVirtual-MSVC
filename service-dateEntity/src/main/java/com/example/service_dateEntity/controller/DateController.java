package com.example.service_dateEntity.controller;

import com.example.service_dateEntity.model.dtos.RequestCreateDateDto;
import com.example.service_dateEntity.model.dtos.RequestFindByDailyIdAndDate;
import com.example.service_dateEntity.model.dtos.ResponseDateDto;
import com.example.service_dateEntity.service.DailyAvailabiltyService;
import com.example.service_dateEntity.service.DateService;
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
@RequestMapping("/dates")
@RequiredArgsConstructor
public class DateController {
    private final DateService dateService;
    private final DailyAvailabiltyService dailyAvailabiltyService;

    @AllowedForEmployeesAndAdmins
    @PostMapping("/create/{id}")
    public ResponseEntity<List<ResponseDateDto> >createDate(@PathVariable String id){
        return new ResponseEntity<>(dailyAvailabiltyService.createDatesByDaily(id), HttpStatus.OK);
    }

    @AllowedForUsersAndEmployeesAndAdmins
    @GetMapping("/list-all")
    public ResponseEntity<List<ResponseDateDto>>listAll(){
        return new ResponseEntity<>(dateService.getAll(),HttpStatus.OK);
    }

    @AllowedForUsersAndEmployeesAndAdmins
    @GetMapping("/list-by-daily-id/{dailyId}")
    public ResponseEntity<List<ResponseDateDto>>findByDailyAvailabilityId(@PathVariable String dailyId){
        return new ResponseEntity<>(dateService.findByDailyAvailabilityId(dailyId),HttpStatus.OK);
    }

    @AllowedForUsersAndEmployeesAndAdmins
    @GetMapping("/find-by-daily-and-date")
    public ResponseEntity<List<ResponseDateDto>>findByDailyIdAndDate(@RequestBody @Valid RequestFindByDailyIdAndDate request){
        return new ResponseEntity<>(dateService.findByDailyIdAndDate(request),HttpStatus.OK);
    }

}
