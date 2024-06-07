package app.backcitas.dto.EPS;


import app.backcitas.models.EPS;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface EPSMapper {
    EPSMapper INSTANCE = Mappers.getMapper(EPSMapper.class);

    EPS toEntity(EPSDto dto);
    EPSDto toDto(EPS entity);
}
