package bean_practice;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class NewAppConfig {
    @Bean(name = "String 1")//tells the Spring Container to put this specific object inside it
    public String str1(){
        return "Welcome to CydeoApp";
    }

    @Primary
    @Bean//tells the Spring Container to put this specific object inside it
    public String str2(){
        return "Spring Core Practice";
    }
}
