package com.mycy.service;

import com.mycy.dto.ProjectDTO;
import com.mycy.dto.TaskDTO;
import com.mycy.entity.User;
import com.mycy.enums.Status;

import java.util.List;

public interface TaskService {

    TaskDTO findById(Long id); //to find a task by id
    List<TaskDTO> findAllTasks();
    void save(TaskDTO dto);
    void update(TaskDTO dto);
    void delete(Long id);
    int totalUncompletedTasks(String projectCode);
    int totalCompletedTasks(String projectCode);

    void deleteByProject(ProjectDTO convertToDTO);

    void completeByProject(ProjectDTO convertToDTO);

    List<TaskDTO> listAllTasksByStatusIsNot(Status complete);

    List<TaskDTO> listAllTasksByStatus(Status complete);

    void updateStatus(TaskDTO task);

    List<TaskDTO> listAllTasksByAssignedEmployee(User assignedEmployee);
}
