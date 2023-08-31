package stereotype_annotations.model;

import org.springframework.stereotype.Component;

/**
 * With stereotype annotation, no need to create methods/objects
 *  limitation with stereotype annotation:
 *      - we cannot use multiple object as we use with bean annotations.
 *      - we cannot use it if we do not create or own the class
 */
@Component
public class Microservices {

    public void getTotalHours() {
        System.out.println("Total Hours: " + 200);
    }
}
