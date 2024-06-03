package app.backcitas.dto.user;

import app.backcitas.Enum.IdentityDocumentType;
import app.backcitas.models.Role;
import app.backcitas.models.Specialization;

public record UserDto(String name,
                      String lastName,
                      IdentityDocumentType identityDocumentType,
                      String idCard,
                      String email,
                      String password,
                      Specialization specialization,
                      Role role) {
}
