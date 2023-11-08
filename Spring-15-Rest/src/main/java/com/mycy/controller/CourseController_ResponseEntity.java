package com.mycy.controller;

import com.mycy.dto.CourseDTO;
import com.mycy.service.CourseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@RestController combines both the @Controller and @ResponseBody annotations internally
@RestController//marks that this class is Rest API Controller
@RequestMapping("/courses/api/v2")
public class CourseController_ResponseEntity {

    private final CourseService courseService;

    public CourseController_ResponseEntity(CourseService courseService) {
        this.courseService = courseService;
    }

    /**
     * ResponseEntity class extends from httpEntity
     * and httpEntity helps to pass headers, status, ect
     * @return ResponseEntity
     */
    @GetMapping
    public ResponseEntity<List<CourseDTO>> getAllCourses(){
        return ResponseEntity
                .status(HttpStatus.ACCEPTED)//passing status code, accepted = 200 = ok
                .header("Version","Cydeo.V2")
                .header("Operation","Get List")
                .body(courseService.getCourses());
    }

    @GetMapping("{id}")
    public ResponseEntity<CourseDTO> getCourseById(@PathVariable("id") Long courseId){
      //status code ok = 200, returning body of the id
        return ResponseEntity.ok(courseService.getCourseById(courseId));
    }

    @PostMapping
    public ResponseEntity<CourseDTO> createCourse(@RequestBody CourseDTO course) {
        return ResponseEntity
                .status(HttpStatus.CREATED)//passing status code, created = 201
                .header("Operation","Create")//passing a header as key & values
                .body(courseService.createCourse(course));//passing a json body in the post request
    }
}
