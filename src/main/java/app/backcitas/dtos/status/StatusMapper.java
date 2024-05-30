package app.backcitas.dtos.status;

import app.backcitas.models.Status;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface StatusMapper {

    StatusMapper INSTANCE = Mappers.getMapper(StatusMapper.class);

    StatusDto statusEntityToStatusDto(Status status);

    Status statusDtoToStatusEntity(StatusDto statusDto);
}
