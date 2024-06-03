package app.backcitas.dto.appointmentsAvailable;

import app.backcitas.models.User;

import java.time.LocalDateTime;

public record AppointmentAvailableToSaveDto(Long id,
                                            LocalDateTime dateTime,
                                            User doctor,
                                            Boolean available) {
}
