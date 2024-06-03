package app.backcitas.dto.appointmentsAvailable;

import app.backcitas.models.AppointmentAvailable;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface AppointmentAvailableMapper {

    AppointmentAvailableMapper INSTANCE = Mappers.getMapper(AppointmentAvailableMapper.class);

    AppointmentAvailable toEntity(AppointmentAvailableDto dto);
    AppointmentAvailable saveDtoToEntity(AppointmentAvailableToSaveDto dto);
    AppointmentAvailableDto toDto(AppointmentAvailable entity);
}
