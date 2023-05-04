package com.cydeo.repository;

import com.cydeo.entity.Genre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface GenreRepository extends JpaRepository<Genre, Long> {
    // ------------------- JPQL QUERIES ------------------- //

    //Write a JPQL query that return all genres (returns a list of all genres), method name does not matter
    @Query("SELECT g from Genre g")
    List<Genre> findAllGenres();
    // ------------------- Native QUERIES ------------------- //

    //Write a native query that returns genres by containing name (a list of genres that contain a specific name)
    @Query(value = "SELECT * FROM genre WHERE name ILIKE concat('%',?1,'%')",nativeQuery = true)
    List<Genre> findAllGenresContaining(@Param("name") String name);
}
