package app.backcitas.dto.appointmentsAvailable;

import app.backcitas.models.User;

import java.time.LocalDateTime;

public record AppointmentAvailableDto(Long id,
                                      LocalDateTime dateTime,
                                      User doctor,
                                      Boolean available) {
}
