package com.mycy.service;

import com.mycy.dto.ProjectDTO;
import com.mycy.entity.User;

import java.util.List;

public interface ProjectService {

    ProjectDTO getByProjectCode(String code);
    List<ProjectDTO> listAllProjects();
    void save(ProjectDTO dto);
    void update(ProjectDTO dto);
    void delete(String code);
    void complete(String projectCode);
    List<ProjectDTO> listAllProjectDetails();

    List<ProjectDTO> listAllByAssignedManager(User assignedManager);
}
