package com.cydeo.repository;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("RH")
public class RegularHours implements HoursRepository{
    @Override
    public int getHours() {
        return 40;
    }
}
