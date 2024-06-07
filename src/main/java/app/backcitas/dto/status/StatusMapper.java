package app.backcitas.dto.status;

import app.backcitas.models.Status;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface StatusMapper {
    StatusMapper INSTANCE = Mappers.getMapper(StatusMapper.class);

    Status toEntity(StatusDto dto);
    StatusDto toDto(Status entity);
}
