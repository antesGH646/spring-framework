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
        // if do not want to pass the code
        when(projectRepository.findByProjectCode(anyString())).thenReturn(project);
        when(projectMapper.convertToDto(project)).thenReturn(projectDTO);

        //Then part: call the service method to perform the mockito
        projectServiceImpl.getByProjectCode(anyString());
        verify(projectRepository).findByProjectCode(anyString());
        verify(projectMapper).convertToDto(any(Project.class));

        //asserting from junit5 jupiter
        assertNotNull(projectServiceImpl.getByProjectCode(anyString()));
    }
}