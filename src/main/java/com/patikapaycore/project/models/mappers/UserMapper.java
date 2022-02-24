package com.patikapaycore.project.models.mappers;

import com.patikapaycore.project.models.dtos.UserDto;
import com.patikapaycore.project.models.dtos.UserResponseDto;
import com.patikapaycore.project.models.entities.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface UserMapper {

    UserDto entityToDto(User entity);
    //@Mapping(target = "",source = "")
    User modelToEntity(UserDto dto);

    UserResponseDto entityToReponseDto(User entity);

    User reponseDtoToEntity(UserResponseDto entity);
}
