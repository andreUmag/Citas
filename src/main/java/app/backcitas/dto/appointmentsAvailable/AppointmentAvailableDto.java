package app.backcitas.dto.appointmentsAvailable;

import app.backcitas.dto.user.UserDto;
import app.backcitas.models.User;

import java.time.LocalDateTime;

public record AppointmentAvailableDto(Long id,
                                      LocalDateTime dateTime,
                                      UserDto doctor,
                                      Boolean available) {
}
