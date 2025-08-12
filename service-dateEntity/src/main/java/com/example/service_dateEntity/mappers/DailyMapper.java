package com.example.service_dateEntity.mappers;

import com.example.service_dateEntity.model.DailyAvailability;
import org.springframework.stereotype.Component;

@Component
public class DailyMapper {

    public DailyAvailability asAvailability(String id) {
        if (id == null) {
            return null;
        }
        DailyAvailability da = new DailyAvailability();
        da.setId(id);
        return da;
    }

    public String asString(DailyAvailability dailyAvailability){
        if (dailyAvailability ==null){
            return null;
        }
        return dailyAvailability.getId();
    }


}
