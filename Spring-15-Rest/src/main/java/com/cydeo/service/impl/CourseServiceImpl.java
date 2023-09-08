package com.cydeo.service.impl;

import com.cydeo.dto.CourseDTO;
import com.cydeo.entity.Course;
import com.cydeo.repository.CourseRepository;
import com.cydeo.service.CourseService;
import com.cydeo.util.MapperUtil;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CourseServiceImpl implements CourseService {

    private final CourseRepository courseRepository;
    private final MapperUtil mapperUtil;

    public CourseServiceImpl(CourseRepository courseRepository, MapperUtil mapperUtil) {
        this.courseRepository = courseRepository;
        this.mapperUtil = mapperUtil;
    }

    /**
     * Converts/maps the CourseDTO object into entity, then saves it into the database,
     * finally returned.
     * @param course CourseDTO
     * @return converted/mapped CourseDTO objects
     */
    @Override
    public CourseDTO createCourse(CourseDTO course) {
        courseRepository.save(mapperUtil.convert(course, new Course()));
        return course;
    }

    /**
     * The Entity Or Course is fetched by its id, then it is mapped to DTO,
     * lastly returned as DTO
     * @param courseId Long
     * @return CourseDTO (fetched then mapped Course to CourseDTO)
     */
    @Override
    public CourseDTO getCourseById(long courseId) {
        Course course = courseRepository.findById(courseId).get(); //findById() is optional, must add .get()
        return mapperUtil.convert(course, new CourseDTO());
    }

    /**
     * The Course is fetched by its Category, mapped to DTO, collected as a list,
     * finally returned.
     * @param category String
     * @return a list of fetched Courses by category
     */
    @Override
    public List<CourseDTO> getCoursesByCategory(String category) {
        List<Course> list = courseRepository.findAllByCategory(category);
        return list.stream().map(obj -> mapperUtil.convert(obj, new CourseDTO())).collect(Collectors.toList());
    }

    /**
     * All the Courses (entities from db) are fetched, mapped to DTO,
     * finally returned.
     * @return a list of fetched Courses
     */
    @Override
    public List<CourseDTO> getCourses() {
        List<Course> list = courseRepository.findAll();
        return list.stream().map(obj -> mapperUtil.convert(obj, new CourseDTO())).collect(Collectors.toList());
    }

    /**
     * A course is updated in the UI meaning DTO object.
     * Therefore, it should be converted to Entity to save the changes in the database.
     *  1) The Course or DTO is converted/mapped to entity
     *  2) The mapped object is first checked it exists in the database
     *  3) If it exists, it should be set to its category, name, etc.
     *  4) it should be saved
     * @param courseId Long
     * @param courseDTO CourseDTO
     */
    @Override
    public void updateCourse(Long courseId, CourseDTO courseDTO) {
        Course course = mapperUtil.convert(courseDTO, new Course());
        courseRepository.findById(courseId).ifPresent(dbCourse -> {
            //the object is set to its category
            dbCourse.setName(course.getName());
            dbCourse.setCategory(course.getCategory());
            dbCourse.setDescription(course.getDescription());
            dbCourse.setRating(course.getRating());

            courseRepository.save(dbCourse);//the updated object is saved to database
        });
    }

    /**
     * A Course is deleted from the database
     * No parameter and return type is needed
     */
    @Override
    public void deleteCourses() {
        courseRepository.deleteAll();
    }

    /**
     * A Course is deleted by its id from the database
     * No parameter and return type is needed
     */
    @Override
    public void deleteCourseById(long courseId) {
        courseRepository.deleteById(courseId);
    }
}
