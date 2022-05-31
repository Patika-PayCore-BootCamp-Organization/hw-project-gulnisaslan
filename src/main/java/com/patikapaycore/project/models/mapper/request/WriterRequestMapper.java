package com.patikapaycore.project.models.mapper.request;

import com.patikapaycore.project.models.dtos.request.WriterTypeRequestDto;
import com.patikapaycore.project.models.entities.Writer;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
@Mapper(componentModel = "spring")
public interface WriterRequestMapper
{
    WriterRequestMapper WRITER_REQUEST_MAPPER = Mappers.getMapper(WriterRequestMapper.class);

    WriterTypeRequestDto map(Writer writer);
}
