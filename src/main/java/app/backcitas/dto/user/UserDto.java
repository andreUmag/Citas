package app.backcitas.dto.user;


import app.backcitas.dto.IdentityDocumentType.IdentityDocumentTypeDto;
import app.backcitas.dto.role.RoleDto;
import app.backcitas.dto.specialization.SpecializationDto;


public record UserDto(Long id, String name,
                      String lastName,
                      IdentityDocumentTypeDto identityDocumentType,
                      String idCard,
                      String email,
                      String password,
                      SpecializationDto specialization,
                      RoleDto role) {
}
