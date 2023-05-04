package com.cydeo.repository;

import com.cydeo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    // ------------------- DERIVED QUERIES ------------------- //

    //Write a derived query to read a user with an email?
    Optional<User> findByEmail(String email);

    //Write a derived query to read a user with a username?
    Optional<User> findByUsername(String email);
    //Write a derived query to list all users that contain a specific name?
     List<User> findUsersByAccountContains(String name);
    //Write a derived query to list all users that contain a specific name in the ignore case mode?
    List<User> findUsersByAccountContainingIgnoreCase(String name);
    //Write a derived query to list all users with an age greater than a specified age?

    // ------------------- JPQL QUERIES ------------------- //

    //Write a JPQL query that returns a user read by email?
    @Query("select u from User u where u.email = ?1 ")
    Optional<User> fetchUserByEmail(@Param("user") String email);
    //Write a JPQL query that returns a user read by username?
    @Query("select u from User u where u.username = ?1 ")
    Optional<User> fetchUserByUser(@Param("username") String email);
    //Write a JPQL query that returns all users?

    // ------------------- Native QUERIES ------------------- //

    //Write a native query that returns all users that contain a specific name?
    @Query(value = "select * from users ilike concat('%',?1,'%') ",nativeQuery = true)
    List<User> getUserByAccountNameContaining(String name);
    //Write a native query that returns all users?
    @Query(value = "select * from user", nativeQuery = true)
    List<User> findAllUsers();
    //Write a native query that returns all users in the range of ages?
    @Query(value = "select ad from AccountDetails where ad.age between ?1 and ?2", nativeQuery = true)
    List<User> findUsersByAccountDetailsAgeRange(@Param("age1") Integer age1, @Param("age2") Integer age2);
    //Write a native query to read a user by email?
    @Query(value = "select u from User u where u.email = ?1",nativeQuery = true)
    Optional<User> getUserByEmail(String email);
}
