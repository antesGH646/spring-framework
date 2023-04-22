package com.cydeo.repository;

import com.cydeo.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.stream.Stream;

/**
 * Use repository when you want to bring data from a database. Since thymeleaf understands
 * java objects, create methods to manipulate the data, then display it on the UI.
 * When repositories make sure to extend the JpaRepository<repositoryName, dataType>
 * The common ways of writing queries are derived queries and @Query annotation queries.
 * Note that writing derived queries is good only with methods having 3-4 parameters, otherwise
 * it would be difficult or almost impossible to read and maintain these queries when adding,
 * filtering, comparison, and result size limiting. For this reason you rather use more flexible
 * queries such as JPQL (Java Persistence Query Language) or native SQL queries
 * (e.g. select * from tableName).
 * The @Query annotation is used for both JPQL and native queries
 * JPQL
 * Since JPQL supports the SQL subset standard, it is not a good
 * choice to use it for more complex queries. JPQL is an abstraction, it might have slight
 * performance issue (The flow is: JPQL => convert to sql ==> access database)
 * When writing JPQL queries through @Query annotations, you may specify parameters through
 * methods either positional parameter use ?parameterName or name-binding parameters.
 * Note that JPQL method names does not matter, it can be any descriptive name
 * In the method signature name-binding parameter uses the @Param("parameterName") annotation,
 * when writing the query uses :parameterName
 * Native SQL
 * To write native SQL make sure pass the nativeQuery = true into the @Query annotation
 * RollingBack
 * If anything happens during inserting, updating, and deleting, the data should roll back
 * to the original state. Use @Modifying, @Transactional annotations
 */
public interface CourseRepository extends JpaRepository<Course,Long> {

    //find all courses by category
    List<Course> findByCategory(String category);
    //find all courses by category and order the entities by name
    List<Course> findByCategoryOrderByName(String category);

    //checks if a course with the provided name exists.
    // return true if the course exists, false otherwise
    boolean existsByName(String name);

    //returns the count of courses for the provided category
    int countByCategory(String category);

    //find all courses that start with the provided course name
    List<Course> findByNameStartsWith(String name);

    //find all courses by category and return a stream (can use java stream)
    Stream<Course> streamByCategory(String category);
    @Query("SELECT c FROM Course c WHERE c.category = :category AND c.rating > :rating")
    List<Course> findAllByCategoryAndRatingGreaterThan(@Param("category") String category, @Param("rating") int rating);
}
