package multi_objects;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class CydeoApp {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(CarConfig.class);
        Car car = context.getBean(Car.class);//will take the object marked with @Primary annotation
       // Car car = context.getBean("car2", Car.class);//specifying the name of the bean for multiple objects
        System.out.println(car.getMake());
    }
}
