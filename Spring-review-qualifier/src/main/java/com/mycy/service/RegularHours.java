package com.mycy.service;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("RH")//identifying: b/c more than one classes are implementing the HoursRepository
public class RegularHours implements HoursRepository {
    @Override
    public int getHours() {
        return 40;
    }
}
