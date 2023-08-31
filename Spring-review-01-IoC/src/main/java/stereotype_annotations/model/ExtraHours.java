package stereotype_annotations.model;

import org.springframework.stereotype.Component;

/**
 * With stereotype annotation, no need to create methods/objects
 *  limitation with stereotype annotation:
 *      - we cannot use multiple object as we use with bean annotations.
 *      - we cannot use it if the class does not belong to you
 */
@Component //labeling to tell spring creat a bean from it
public class ExtraHours {

    public Integer getHours() {
        return 45;
    }
}
