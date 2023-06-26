package com.cydeo.service.impl;

import com.cydeo.dto.TaskDTO;
import com.cydeo.entity.Task;
import com.cydeo.mapper.TaskMapper;
import com.cydeo.repository.TaskRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)//marking mockito annotations usage
class TaskServiceImplTest {

    @Mock
    TaskMapper taskMapper;
    @Mock
    TaskRepository taskRepository;
    @InjectMocks
    TaskServiceImpl taskService;

    @ParameterizedTest
    @ValueSource(longs = {1L,2L,3L,-5L})
    void findById(long id) {//the actual method accepts parameter
        //Given:
        Task task = new Task();//the actual method uses entity

        when(taskRepository.findById(id)).thenReturn(Optional.of(task));
        when(taskMapper.convertToDTO(task)).thenReturn(new TaskDTO());

        //When: the findById() is called
        taskRepository.findById(id);

        //Then: the mocking is executed
        verify(taskRepository).findById(id);//passing id
        verify(taskRepository).findById(anyLong());//or passing anyLong()

        verify(taskMapper).convertToDTO(any(Task.class));
        verify(taskMapper).convertToDTO(task);
    }

    /**
     * Mockito developers added the BDDMockito class
     * for those who want to perform unit tests with
     * BDD style.
    */
    @Test
    void findByIdWithBDDStyle() {
       // Given:
        Task task = new Task();
        given(taskRepository.findById(anyLong())).willReturn(Optional.of(task));
        given(taskMapper.convertToDTO(task)).willReturn(new TaskDTO());
        //When:
        taskService.findById(anyLong());
        //Then:
        then(taskRepository).should().findById(anyLong());
        then(taskRepository).should(never()).findById(-5L);
    }

    @Test
    void update() {
    }
}