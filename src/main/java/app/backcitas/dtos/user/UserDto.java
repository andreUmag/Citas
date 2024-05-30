package app.backcitas.dtos.user;

import java.util.UUID;

public record UserDto(
        UUID id,
        String fullName,
        Integer idCard,
        String email,
        String password,
        UUID roleId) {
}
