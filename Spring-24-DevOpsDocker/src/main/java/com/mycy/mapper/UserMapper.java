package com.mycy.mapper;

import com.mycy.dto.UserDTO;
import com.mycy.entity.User;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component//tells spring to create a bean from this class and return it whenever needed
public class UserMapper {
    private final ModelMapper modelMapper;

    public UserMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public User convertToEntity(UserDTO dto) {
        return modelMapper.map(dto, User.class);
    }

    public UserDTO convertToDto(User entity) {
        return modelMapper.map(entity, UserDTO.class);
    }
}
