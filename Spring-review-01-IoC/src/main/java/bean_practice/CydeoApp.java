package bean_practice;



import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import stereotype_annotations.model.DataStructure;
import stereotype_annotations.model.ExtraHours;
import stereotype_annotations.model.Microservices;

public class CydeoApp {
    //how to create spring container ?
    public static void main(String[] args) {
        ApplicationContext container =
                new AnnotationConfigApplicationContext(AppConfig.class);

        DataStructure ds = container.getBean(DataStructure.class);
        ds.getTotalHours();
        Microservices ms = container.getBean(Microservices.class);
        ms.getTotalHours();

        ExtraHours extraHours = container.getBean(ExtraHours.class);

        System.out.println("extraHours.getHours() = " + extraHours.getHours());
    }

}
