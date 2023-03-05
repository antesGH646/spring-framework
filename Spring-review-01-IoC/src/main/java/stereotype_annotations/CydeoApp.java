package stereotype_annotations;

import bean_practice.AppConfig;
import stereotype_annotations.model.DataStructure;
import stereotype_annotations.model.ExtraHours;
import stereotype_annotations.model.Microservices;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class CydeoApp {

    public static void main(String[] args) {
        ApplicationContext container = new AnnotationConfigApplicationContext(AppConfig.class);

        DataStructure ds = container.getBean(DataStructure.class);
        ds.getTotalHours();
        Microservices ms = container.getBean(Microservices.class);
        ms.getTotalHours();

        ExtraHours ers = container.getBean(ExtraHours.class);

        System.out.println("extraHours.getHours() = " + ers.getHours());
    }
}

