package com.mycy.repository;

import com.mycy.entity.Project;
import com.mycy.entity.Task;
import com.mycy.entity.User;
import com.mycy.enums.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {

    @Query("SELECT COUNT(t) FROM Task t WHERE t.project.projectCode = ?1 AND t.taskStatus <> 'COMPLETE' ")
    int totalUncompletedTasks(String projectCode);

    @Query(value = "SELECT COUNT(*)" +
            "FROM tasks t JOIN projects p on t.project_id = p.id " +
            "WHERE p.project_code = ?1 AND t.task_status = 'COMPLETE'", nativeQuery = true)
    int totalCompletedTasks(String projectCode);

    List<Task> findAllByProject(Project project);//follows derived query naming convention

    List<Task> findAllByTaskStatusIsNotAndAssignedEmployee(Status status, User assignedEmployee);

    List<Task> findAllByTaskStatusAndAssignedEmployee(Status status, User assignedEmployee);

    List<Task> findAllByAssignedEmployee(User assignedEmployee);
}