package stereotype_annotations.model;

import lombok.*;
import org.springframework.stereotype.Component;

@Component //cannot use @Component on custom classes, POJO classes, and Interfaces
@Data
public class DataStructure {

    @NonNull
    ExtraHours extraHours;

//    @Autowired
//    public DataStructure(ExtraHours extraHours) {
//        this.extraHours = extraHours;
//    }

    public void getTotalHours(){
        System.out.println("Total hours: "+(35 + extraHours.getHours()));
    }
}
