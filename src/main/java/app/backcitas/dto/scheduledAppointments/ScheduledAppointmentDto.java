package app.backcitas.dto.scheduledAppointments;

import app.backcitas.Enum.Status;
import app.backcitas.dto.user.UserDto;
import app.backcitas.models.User;

import java.time.LocalDateTime;

public record ScheduledAppointmentDto(Long id,
                                      UserDto doctor,
                                      UserDto patient,
                                      LocalDateTime dateTime,
                                      Status status) {
}
