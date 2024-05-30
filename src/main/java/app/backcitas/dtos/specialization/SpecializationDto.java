package app.backcitas.dtos.specialization;

import java.util.List;
import java.util.UUID;

public record SpecializationDto(
        UUID id,
        String name,
        String description,
        List<UUID> appointmenstIds) {
}
