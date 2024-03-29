package com.mycy.mapper;

import com.mycy.dto.TaskDTO;
import com.mycy.entity.Task;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class TaskMapper {

    private final ModelMapper modelMapper;

    public TaskMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public Task convertToEntity(TaskDTO dto){
        return modelMapper.map(dto,Task.class);
    }

    public TaskDTO convertToDTO(Task entity){
        return modelMapper.map(entity,TaskDTO.class);
    }
}
