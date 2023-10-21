package com.cydeo.service.impl;

import com.cydeo.dto.ProjectDTO;
import com.cydeo.entity.Project;
import com.cydeo.mapper.ProjectMapper;
import com.cydeo.repository.ProjectRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ProjectServiceImplTest {

    @Mock
    ProjectRepository projectRepository;

    @Mock
    ProjectMapper projectMapper;

    @InjectMocks//inject mock into the service instead of the real objects
    ProjectServiceImpl projectServiceImpl;

    @Test
    void getByProjectCode() {

        //Given part
        Project project = new Project();//entity
        ProjectDTO projectDTO = new ProjectDTO();//dto

        //When part: tell how to mock, mockito has anyString() method
        // if you do not want to pass the code
        when(projectRepository.findByProjectCode(anyString())).thenReturn(project);
        when(projectMapper.convertToDto(project)).thenReturn(projectDTO);

        //Then part: call the service method to perform the mockito
        projectServiceImpl.getByProjectCode(anyString());
        verify(projectRepository).findByProjectCode(anyString());
        verify(projectMapper).convertToDto(any(Project.class));

        //asserting from junit5 jupiter
        assertNotNull(projectServiceImpl.getByProjectCode(anyString()));
    }

    /**
     * Instead of testing the real thrown exception this method mocks to test
     * if the findByProjectCode() method throws an exception
     * NB. In JUnit expected comes first
     */
    @Test
    void getByProjectCodeExceptionTest() {
        //define the mocks, assumes that findByProjectCode() is throwing an exception
        when(projectRepository.findByProjectCode("")).thenThrow(new RuntimeException("Project Not Found"));
        //assertThrows() accepts the type of exception class and the method that is throwing the exception
        Throwable throwable = assertThrows(RuntimeException.class, () -> projectServiceImpl.getByProjectCode(""));
        verify(projectRepository).findByProjectCode(anyString());
        //capturing the actual exception and comparing it with expected
        assertEquals("Project Not Found",throwable.getMessage());
    }

    @Test
    void saveTest() {
        ProjectDTO projectDTO = new ProjectDTO();
        Project project = new Project();
        //how the save method acts when mocked, objects are saved as entity in db
        when(projectMapper.convertToEntity(projectDTO)).thenReturn(project);//mocks converted dto to entity and returns
        when(projectRepository.save(project)).thenReturn(project);//mocks as saved to db and returns what is saved
       //calling the save method to execute the mocking line below
        projectServiceImpl.save(projectDTO);

        verify(projectRepository).save(project);//verifies if is saving a project
    }
}