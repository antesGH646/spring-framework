package com.mycy;

import org.springframework.stereotype.Component;

@Component//tell the spring to create a bean from this object
public class OfficeHours {

    public int getHours() {
        return 45;
    }
}
