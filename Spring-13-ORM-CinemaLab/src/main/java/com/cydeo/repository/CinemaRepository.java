package com.cydeo.repository;

import com.cydeo.entity.Cinema;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface CinemaRepository extends JpaRepository<Cinema, Long> {

    // ------------------- DERIVED QUERIES ------------------- //
    //TASK 6 min
    //Write a derived query to get cinema with a specific name
    Optional<Cinema> findByName(String name);

    //Write a derived query to read sorted the top 3 cinemas that contains a specific sponsored name
    List<Cinema> findFirst3BySponsoredNameContainingOrderBySponsoredName(String sponsoredName);

    //Write a derived query to list all cinemas in a specific country
    List<Cinema> findAllByLocationCountry(String country);

    //Write a derived query to list all cinemas with a specific name or sponsored name
    List<Cinema> findAllByNameOrSponsoredName(String name, String sponsoredName);

    // ------------------- JPQL QUERIES ------------------- //

    //Write a JPQL query to read the cinema name with a specific id
    @Query("select c from Cinema c where c.id = ?1")
    String findByName(@Param("id") Long id);//when id is passed it returns a string of a Cinema name

    // ------------------- Native QUERIES ------------------- //

    //Write a native query to read all cinemas by location country (return a list of cinemas by a country)
    @Query(value = "SELECT * FROM cinema c JOIN location l ON c.location_id = l.id WHERE l.country = ?1",nativeQuery = true)
    List<Cinema> findAllCinemasBasedOnLocationCountry(@Param("locationCountry") String locationCountry);

    //Write a native query to read all cinemas by name or sponsored name contains a specific pattern
    @Query(value = "SELECT * FROM cinema WHERE name ILIKE concat('%',?1,'%') OR " +
            "sponsored_name ILIKE concat('%',?1,'%')",nativeQuery = true)
    List<Cinema> findAllCinemasByNameOrSponsoredName(@Param("pattern") String pattern);

    //Write a native query to sort all cinemas by name
    @Query(value = "SELECT * FROM cinema ORDER BY name ",nativeQuery = true)
    List<Cinema> sortByName();

    //Write a native query to distinct all cinemas by sponsored name
    @Query(value = "SELECT DISTINCT sponsored_name FROM cinema",nativeQuery = true)
    List<String> findDistinctCinemasBySponsoredName();

}