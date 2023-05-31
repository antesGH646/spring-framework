package com.cydeo.controller;

import com.cydeo.dto.CourseDTO;
import com.cydeo.service.CourseService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController //combines or includes both the @Controller and @ResponseBody internally
@RequestMapping("/courses/api/v1") //specifying the endpoint
public class CourseController {

    //defining CourseService to call the implementing methods
    private final CourseService courseService;

    //injection through the constructor
    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    /**
     * In API, methods do not return HTML pages instead
     * return objects or data, so others can use the data
     * from the API
     * @return lists of Course
     */
    @GetMapping
    public List<CourseDTO> getAllCourses(){
        List<CourseDTO> list = courseService.getCourses();
        return list;
    }

    /**
     * Fetches a specific Course name by its id
     * when hit the url with the path
     * e.g /courses/api/v1/3
     * @param courseId Long
     * @return CourseDTO a course by its id path
     */
    @GetMapping("{id}") // e.g. /courses/api/v1/3
    public CourseDTO getCourseById(@PathVariable("id") Long courseId){
        return courseService.getCourseById(courseId);
    }

    /**
     * Fetches a list of specific category from the database
     * when you hit the url with the category name
     * e.g /courses/api/v1/category/Spring
     * @param category String
     * @return List of specific categories as passed in the url path
     */
    @GetMapping("category/{name}")
    public List<CourseDTO> getCourseByCategory(@PathVariable("name") String category){
        return courseService.getCoursesByCategory(category);
    }

    /**
     * The @RequestBody captures the CourseDTO object in Json format
     * and passes it to createCourse
     * @param course CourseDTO
     * @return mapped CourseDTO
     */
    @PostMapping
    public CourseDTO createCourse(@RequestBody CourseDTO course){
        return courseService.createCourse(course);
    }

    /**
     * Updates a specific data in the database
     * when you hit the url with the path or id
     * e.g /courses/api/v1/3
     * @param courseId Long
     * @param course CourseDTO
     */
    @PutMapping("{id}") //e.g /courses/api/v1/3
    public void updateCourse(@PathVariable("id") Long courseId,@RequestBody CourseDTO course){
        courseService.updateCourse(courseId,course);
    }

    /**
     * Deletes a data by the id, when you pass the id
     * in the url e.g /courses/api/v1/3
     * @param courseId Long
     */
    @DeleteMapping("{id}") //e.g /courses/api/v1/3
    public void deleteCourseById(@PathVariable("id") Long courseId){
        courseService.deleteCourseById(courseId);
    }

    /**
     * Deletes all the data from the database
     * no need to pass the path in the url
     * e.g /courses/api/v1/3
     */
    @DeleteMapping //e.g /courses/api/v1
    public void deleteCourses(){
        courseService.deleteCourses();
    }






































}
