package com.cydeo.service;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("OTH")//identifying: b/c more than one classes are implementing the HoursRepository
public class OvertimeHours implements HoursRepository {
    @Override
    public int getHours() {
        return 15;
    }
}
