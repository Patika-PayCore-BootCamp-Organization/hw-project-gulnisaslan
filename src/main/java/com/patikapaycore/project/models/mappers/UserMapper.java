package com.patikapaycore.project.models.mappers;

import com.patikapaycore.project.models.dtos.UserDto;
import com.patikapaycore.project.models.entities.User;
import org.mapstruct.Mapper;

@Mapper
public interface UserMapper {

    UserDto entityToDto(User entity);

    User modelToEntity(UserDto dto);
}
