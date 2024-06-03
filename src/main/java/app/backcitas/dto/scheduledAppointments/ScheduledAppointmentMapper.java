package app.backcitas.dto.scheduledAppointments;

import app.backcitas.models.ScheduledAppointments;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ScheduledAppointmentMapper {
    ScheduledAppointmentMapper INSTANCE = Mappers.getMapper(ScheduledAppointmentMapper.class);

    ScheduledAppointments saveDtoToEntity(ScheduledAppointmentToSaveDto scheduledAppointmentToSaveDto);
    ScheduledAppointmentToSaveDto toEntity(ScheduledAppointmentDto scheduledAppointmentDto);
    ScheduledAppointmentDto toDto(ScheduledAppointments scheduledAppointments);

}
