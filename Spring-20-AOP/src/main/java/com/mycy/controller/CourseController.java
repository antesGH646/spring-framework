package com.mycy.controller;

import com.mycy.annotation.ExecutionTime;
import com.mycy.annotation.Loggable;
import com.mycy.dto.CourseDTO;
import com.mycy.service.CourseService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/courses/api/v1")
public class CourseController {
    private final CourseService courseService;

    //creating a logger
    //Logger logger = LoggerFactory.getLogger(CourseController.class);

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping
    public List<CourseDTO> getAllCourses() {

        //Logging before the logic: the {} will be initialized by the parameters respectively
       // logger.info("Before -> Controller: {} - Method {} "," CourseController","getCourses()");

        //the logic is to display all the courses
        List<CourseDTO> list = courseService.getCourses();

        //the 1st {} will be initialized from the 1st parameters CourseController, and so on
        //logger.info("After -> Controller: {} - Method : {} - Output : {}"," CourseController","getCourses()", list.toString());

        return list;
    }


    @ExecutionTime
    @GetMapping("/{id}")
    public CourseDTO getCourseById(@PathVariable("id") Long courseId) {
        return courseService.getCourseById(courseId);
    }

    @Loggable
    @GetMapping("/category/{name}")
    public List<CourseDTO> getCourseByCategory(@PathVariable("name") String category) {
        return courseService.getCoursesByCategory(category)       ;
    }

    @Loggable
    @PostMapping
    public CourseDTO createCourse(@RequestBody CourseDTO course) {
        return courseService.createCourse(course);
    }

    @PutMapping("/{id}")
    public void updateCourse(@PathVariable("id") Long courseId, @RequestBody CourseDTO course) {
        courseService.updateCourse(courseId, course);
    }

    @DeleteMapping("/{id}")
    public void deleteCourseById(@PathVariable("id") Long courseId) {
        courseService.deleteCourseById(courseId);
    }

    @DeleteMapping
    public void deleteCourses() {
        courseService.deleteCourses();
    }
}
