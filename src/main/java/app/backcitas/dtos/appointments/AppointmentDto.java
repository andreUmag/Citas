package app.backcitas.dtos.appointments;

import java.time.LocalDateTime;
import java.util.UUID;

public record AppointmentDto(
        UUID id,
        LocalDateTime date,
        UUID doctorId,
        UUID patientId,
        UUID locationId,
        UUID statusId,
        UUID specializationId) {
}

