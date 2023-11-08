package com.mycy;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
@Data
public class Java {
  //  @Autowired //using autowired on field level, but it will be depreciated soon
    OfficeHours officeHours; //Java do not know about it unless you inject it

  /**
   * if you are NOT using lombok annotation e.g the above @AllArgsConstructor
   * you need to create a constructor and use @Autowired on the constructor level,
   * otherwise Spring will throw a null pointer exception.
   * However, if you are using lombok annotation Spring will inject the bean automatically
   * no need to create a constructor and Add @Autowired annotation
   */
//     @Autowired
//    public Java(OfficeHours officeHours) {
//        this.officeHours = officeHours;
//    }

    public void getTeachingHours() {
        System.out.println("Total teaching hours: " + (650 + officeHours.getHours()));
    }
}
