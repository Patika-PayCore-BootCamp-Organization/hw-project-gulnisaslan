package com.patikapaycore.project.models.mapper.request;

import com.patikapaycore.project.models.dtos.request.UserRequestDto;
import com.patikapaycore.project.models.entities.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface UserRequestMapper {

    UserRequestMapper USER_REQUEST_MAPPER = Mappers.getMapper(UserRequestMapper.class);

    UserRequestDto map(User user);

}
