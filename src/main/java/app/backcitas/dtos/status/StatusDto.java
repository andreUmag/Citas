package app.backcitas.dtos.status;

import java.util.List;
import java.util.UUID;
public record StatusDto(
        UUID id,
        String name,
        String description,
        List<UUID> appointmenstIds) {
}
