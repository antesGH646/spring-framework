package bean_practice;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration //directs the Spring Container to create beans from the below Classes
public class AppConfig {
    @Bean //tells the Spring Container to put this object inside it
    public FullTimeEmployee fullTimeEmployee(){
        return new FullTimeEmployee();
    }

    @Bean //tells the Spring Container to put this object inside it
    public PartTimeEmployee partTimeEmployee(){
        return new PartTimeEmployee();
    }
}
