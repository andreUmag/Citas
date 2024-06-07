package app.backcitas.dto.scheduledAppointments;

import app.backcitas.dto.status.StatusDto;
import app.backcitas.dto.user.UserDto;

import java.time.LocalDateTime;

public record ScheduledAppointmentDto(Long id,
                                      UserDto doctor,
                                      UserDto patient,
                                      LocalDateTime dateTime,
                                      StatusDto status) {
}
