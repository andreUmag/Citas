package app.backcitas.dtos.specialization;

import app.backcitas.models.Specialization;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface SpecializationMapper {

    SpecializationMapper INSTANCE = Mappers.getMapper(SpecializationMapper.class);

    SpecializationDto specializationEntityToSpecializationDto(Specialization specialization);

    Specialization specializationDtoToSpecializationEntity(SpecializationDto specializationDto);
}
