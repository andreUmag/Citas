package app.backcitas.dto.specialization;

import app.backcitas.models.Specialization;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface SpecializationMapper {

    SpecializationMapper INSTANCE = Mappers.getMapper(SpecializationMapper.class);

    Specialization toEntity(SpecializationDto specializationDto);
    SpecializationDto toDto(Specialization specialization);
    Specialization saveDtoToEntity(SpecializationToSaveDto specializationToSaveDto);
}
