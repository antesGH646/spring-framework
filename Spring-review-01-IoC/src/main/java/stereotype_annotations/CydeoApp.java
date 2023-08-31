package stereotype_annotations;

import stereotype_annotations.config.AppConfig;
import stereotype_annotations.model.DataStructure;
import stereotype_annotations.model.ExtraHours;
import stereotype_annotations.model.Microservices;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Inside a runner class,
 *  -you create a Spring Container
 *  -Pass the class names as arguments to create bean from them
 */
public class CydeoApp {

    public static void main(String[] args) {
        //creating a Spring container, pass the config class
        ApplicationContext container = new AnnotationConfigApplicationContext(AppConfig.class);
        //Telling the container to create and store a bean from the classes passed in the argument
        container.getBean(DataStructure.class).getTotalHours();
        Microservices ms = container.getBean(Microservices.class);
        ms.getTotalHours(); //calling a method using the created bean
        ExtraHours ers = container.getBean(ExtraHours.class);
        System.out.println("extraHours.getHours() = " + ers.getHours());
    }
}

