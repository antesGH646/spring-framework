package bean_annotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class CydeoApp {

    public static void main(String[] args) {
        //Creating a Spring Container to create beans and manage injections, pass the config files as parameters
        ApplicationContext container =
                new AnnotationConfigApplicationContext(AppConfig.class, NewAppConfig.class);

        //telling to create a bean from the class passed as argument
        FullTimeEmployee ft = container.getBean(FullTimeEmployee.class);
        ft.createAccount();

        PartTimeEmployee pt = container.getBean(PartTimeEmployee.class);
        pt.createAccount();//calling the method using the created bean

        String str1 = container.getBean(String.class);
        System.out.println(str1);

        String str2 = container.getBean(String.class);
        System.out.println(str2);
    }

}
