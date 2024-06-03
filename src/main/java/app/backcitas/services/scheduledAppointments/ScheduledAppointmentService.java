package app.backcitas.services.scheduledAppointments;

import app.backcitas.dto.scheduledAppointments.ScheduledAppointmentDto;
import app.backcitas.dto.scheduledAppointments.ScheduledAppointmentToSaveDto;
import app.backcitas.exception.NotFoundExceptionEntity;

import java.util.List;

public interface ScheduledAppointmentService {
    ScheduledAppointmentDto saveScheduledAppointment(ScheduledAppointmentToSaveDto appointment);
    ScheduledAppointmentDto updateScheduledAppointment(Long appointmentId, ScheduledAppointmentToSaveDto appointment) throws NotFoundExceptionEntity;
    ScheduledAppointmentDto findScheduledAppointmentById(Long appointmentId) throws NotFoundExceptionEntity;
    void removeScheduledAppointment(Long appointmentId);
    List<ScheduledAppointmentDto> getAllScheduledAppointments();

}
