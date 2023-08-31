package com.cydeo.repository;

import com.cydeo.entity.Project;
import com.cydeo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProjectRepository extends JpaRepository<Project, Long> {
    Project findByProjectCode(String code);//fetches a code from the db

    List<Project> findAllProjectsByAssignedManager(User manager);
}