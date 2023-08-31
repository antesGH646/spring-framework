package stereotype_annotations.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration//tells the Spring Container to follow the direction below
//tells the Spring Container to look for classes inside stereotype_annotations package
@ComponentScan(basePackages = "stereotype_annotations")
public class AppConfig {
    /*
    Inside the stereotype annotation config file no need to add the object
     */
}
