package app.backcitas.dtos.location;

import java.util.List;
import java.util.UUID;

public record LocationDto(
        UUID id,
        String name,
        String description,
        List<UUID> appointmenstIds) {
}
