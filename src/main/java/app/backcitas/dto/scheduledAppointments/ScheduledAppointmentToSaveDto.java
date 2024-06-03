package app.backcitas.dto.scheduledAppointments;

import app.backcitas.Enum.Status;
import app.backcitas.models.User;

import java.time.LocalDateTime;

public record ScheduledAppointmentToSaveDto(Long id,
                                            User doctor,
                                            User patient,
                                            LocalDateTime dateTime,
                                            Status status) {
}
