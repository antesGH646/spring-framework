package stereotype_annotations.model;

import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 **
 * With stereotype annotation, no need to create methods/objects
 *  limitation with stereotype annotation:
 *      - we cannot use multiple object as we use with bean annotations.
 *      - we cannot use it if we do not create or own the class.
          You cannot use @Component on custom classes, on POJO classes,
          external classes or classes that you don't own, and Interfaces
          You can only use @Component annotation on classes that you can edit or created
          If you have a class that do not have any relationship you must create
          Has-A relationship before you can use the object. To create the Has-A
          relationship you use the @Autowired annotation to inject the dependency.
          Autowired annotation is placed on a method level
          If you are using lombok annotation you do not need to use the @Autowired
          annotation which tells the Spring Container to inject an object from.
 */
@Component
@Data
public class DataStructure {

    @NonNull //indicates that this is a required field, it cannot be null
    ExtraHours extraHours;

//    @Autowired
//    public DataStructure(ExtraHours extraHours) {
//        this.extraHours = extraHours;
//    }

    public void getTotalHours(){
        System.out.println("Total hours: "+(35 + extraHours.getHours()));
    }
}
