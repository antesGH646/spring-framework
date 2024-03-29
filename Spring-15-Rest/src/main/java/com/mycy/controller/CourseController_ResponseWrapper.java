package com.mycy.controller;

import com.mycy.entity.ResponseWrapper;
import com.mycy.service.CourseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController//marks that this is a Rest-API Controller, combines both the @Controller and @ResponseBody internally
@RequestMapping("/courses/api/v3")
public class CourseController_ResponseWrapper {

    private final CourseService courseService;

    public CourseController_ResponseWrapper(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping
    public ResponseEntity<ResponseWrapper> getAllCourses(){

        return ResponseEntity
                .status(HttpStatus.OK)
                .header("Version","Cydeo.V3")
                .body(new ResponseWrapper("successfully retrieved",courseService.getCourses()));
    }

    @GetMapping("{id}")
    public ResponseEntity<ResponseWrapper> getCourseById(@PathVariable("id") Long courseId){
        return ResponseEntity.ok(new ResponseWrapper("course:" + courseId + "retrieved",courseService.getCourseById(courseId)));
    }
}
