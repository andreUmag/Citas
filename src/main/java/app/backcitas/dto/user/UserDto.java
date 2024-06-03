package app.backcitas.dto.user;

import app.backcitas.Enum.IdentityDocumentType;
import app.backcitas.dto.role.RoleDto;
import app.backcitas.dto.specialization.SpecializationDto;
import app.backcitas.models.Role;
import app.backcitas.models.Specialization;

public record UserDto(Long id, String name,
                      String lastName,
                      IdentityDocumentType identityDocumentType,
                      String idCard,
                      String email,
                      String password,
                      SpecializationDto specialization,
                      RoleDto role) {
}
