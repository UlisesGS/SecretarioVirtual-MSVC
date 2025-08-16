package com.example.service_dateEntity.service.impl;


import com.example.service_dateEntity.mappers.DailyAvailabilityMapper;
import com.example.service_dateEntity.mappers.DateMapper;
import com.example.service_dateEntity.model.DailyAvailability;
import com.example.service_dateEntity.model.DateEntity;
import com.example.service_dateEntity.model.dtos.*;
import com.example.service_dateEntity.model.enums.DaysOfTheWeek;
import com.example.service_dateEntity.repository.DailyAvailabilityRepository;
import com.example.service_dateEntity.service.DailyAvailabiltyService;
import com.example.service_dateEntity.service.DateService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DailyAvailabilityServiceImpl implements DailyAvailabiltyService {
    private final DailyAvailabilityRepository availabilityRepository;
    private final DailyAvailabilityMapper availabilityMapper;
    private final DateService dateService;
    private final DateMapper dateMapper;

    @Override
    public ResponseDailyAvailabilityDto create(RequestCreateAvailabilityDto createAvailabilityDto) {
        System.out.println(createAvailabilityDto);
        DailyAvailability dailyAvailability=availabilityMapper
                .requestCreateAvailabilityToDailyAvailability(createAvailabilityDto);
        System.out.println(dailyAvailability);

        dailyAvailability= availabilityRepository.save(dailyAvailability);
        System.out.println(dailyAvailability);
        System.out.println(availabilityMapper.dailyAvailabilityToDailyAvailabilityDto(dailyAvailability));
        return availabilityMapper.dailyAvailabilityToDailyAvailabilityDto(dailyAvailability);
    }

    @Override
    public List<ResponseDailyAvailabilityDto> getAll() {
        List<DailyAvailability>dailyAvailabilities=availabilityRepository.findAll();
        return availabilityMapper.dailyAvailabilityListToDailyAvailabilityDtoList(dailyAvailabilities);
    }

    @Override
    public List<ResponseDateDto> findAllByDayAndEmployee(RequestFindAllDatesByEmployeeAndDay request) {
        List<DateEntity>dateEntityList=availabilityRepository.
                findAllByDayAndEmployee(request.dayOfTheWeek(),request.employeeId());
        return dateMapper.listEntityToListDto(dateEntityList);
    }

    @Override
    public List<ResponseDateDto> createDatesByDaily(String dailyId) {
        DailyAvailability dailyAvailability=availabilityRepository.findById(dailyId)
                .orElseThrow(()->new RuntimeException("daily no encontrado"));
        List<Double>rangeList=dailyAvailability.getRange();
        System.out.println("tamaño de la lista: "+rangeList.size());

        for (int i = 0; i <(rangeList.size()/2) ; i++) {
            System.out.println("valor de i: "+i);
            LocalTime startTime=toLOcalTime(rangeList.get(i*2));
            LocalTime endTime=toLOcalTime(rangeList.get((i*2)+1));
            System.out.println("valor de start: "+startTime);
            System.out.println("valor de end: "+endTime);


            createDates(startTime,endTime, dailyAvailability.getDuration(),dailyId, dailyAvailability.getDayOfTheWeek(), dailyAvailability.getRest());
        }

        return new ArrayList<>();//que retorne todos los dates o lo que quieras
    }

    @Override
    public List<ResponseDateDto> findAllByDayAndEmployeeAndDate(RequestFindAllByDayAndEmployeeAndDate request) {
        List<DateEntity>dateEntityList=availabilityRepository
                .findAllByDayAndEmployeeAndDate(request.dayOfTheWeek(), request.employeeId(), request.dateOfMonth());
        return dateMapper.listEntityToListDto(dateEntityList);
    }

    private LocalTime toLOcalTime(Double aDouble){
        int wholePart= aDouble.intValue();
        int decimal = (int) ((aDouble - wholePart) * 100);
        return LocalTime.of(wholePart,decimal);
    }

    private int createDates(LocalTime startTime, LocalTime endTime, Integer duration, String dailyId, DaysOfTheWeek daysOfTheWeek, Integer rest){
        Integer daysCreated=0;
        List<LocalDate>listOfDays=getAllDatesForDayInMonth(2025,8,toDayOfWeek(daysOfTheWeek));
        System.out.println("dias a crear: "+listOfDays.size());
        for (LocalDate day:listOfDays){ //recorre todos los dias
            LocalTime counter=startTime;
            System.out.println("dia: "+day);
            while (counter.plusMinutes(duration).isBefore(endTime)){
                System.out.println("valor de counter: "+counter);
                LocalDateTime toCreate=day.atTime(counter);
                RequestCreateDateDto requestCreateDateDto = new RequestCreateDateDto(duration,toCreate,dailyId,false);
                counter=counter.plusMinutes(duration+rest);
                //llama al service de date y crea un turno pasandole el request
                dateService.createDate(requestCreateDateDto);
                daysCreated++;
            }
        }
        return daysCreated;
    }

    private List<LocalDate> getAllDatesForDayInMonth(int year, int month, DayOfWeek targetDay) {
        List<LocalDate> dates = new ArrayList<>();

        // Empezamos en el primer día del mes
        LocalDate date = LocalDate.of(year, month, 1);

        // Movemos la fecha hasta el primer día que coincida con targetDay
        while (date.getDayOfWeek() != targetDay) {
            date = date.plusDays(1);
        }

        // Recorremos el mes sumando de 7 en 7 días
        while (date.getMonthValue() == month) {
            dates.add(date);
            date = date.plusWeeks(1);
        }

        return dates;
    }

    public DayOfWeek toDayOfWeek(DaysOfTheWeek day) {
        switch (day) {
            case LUNES:      return DayOfWeek.MONDAY;
            case MARTES:     return DayOfWeek.TUESDAY;
            case MIERCOLES:  return DayOfWeek.WEDNESDAY;
            case JUEVES:     return DayOfWeek.THURSDAY;
            case VIERNES:    return DayOfWeek.FRIDAY;
            case SABADO:     return DayOfWeek.SATURDAY;
            case DOMINGO:    return DayOfWeek.SUNDAY;
            default: throw new IllegalArgumentException("Día no válido: " + day);
        }
    }
}
