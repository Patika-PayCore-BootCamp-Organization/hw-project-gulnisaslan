package com.patikapaycore.project.models.mapper.response;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface WriterResponseDtoMapper {

    WriterResponseDtoMapper WRITER_RESPONSE_DTO_MAPPER= Mappers.getMapper(WriterResponseDtoMapper.class);

}
