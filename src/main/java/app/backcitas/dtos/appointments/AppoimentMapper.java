package app.backcitas.dtos.appointments;

import app.backcitas.models.Appointmenst;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AppoimentMapper {

    AppoimentMapper INSTANCE = Mappers.getMapper(AppoimentMapper.class);

    AppointmentDto appoimentEntityToAppoimentDto(Appointmenst appointmenst);

    Appointmenst appoimentDtoToAppoimentEntity(AppointmentDto appointmentDto);
}
