package app.backcitas.services.appointmentsAvailable;

import app.backcitas.dto.appointmentsAvailable.AppointmentAvailableDto;
import app.backcitas.dto.appointmentsAvailable.AppointmentAvailableToSaveDto;
import app.backcitas.exception.NotFoundExceptionEntity;

import java.util.List;

public interface AppointmentAvailableService {
    AppointmentAvailableDto saveAppointmentAvailable(AppointmentAvailableToSaveDto appointment);
    AppointmentAvailableDto updateAppointmentAvailable(Long appointmentId, AppointmentAvailableToSaveDto appointment) throws NotFoundExceptionEntity;
    AppointmentAvailableDto findAppointmentAvailableById(Long appointmentId) throws NotFoundExceptionEntity;
    void removeAppointmentAvailable(Long appointmentId);
    List<AppointmentAvailableDto> getAllAppointmentAvailable();

}
