package app.backcitas.services.role;

import app.backcitas.dto.role.RoleDto;
import app.backcitas.dto.role.RoleToSaveDto;
import app.backcitas.exception.NotFoundExceptionEntity;

import java.util.List;

public interface RoleService {
    RoleDto saveRole(RoleToSaveDto role);
    RoleDto updateRole(Long roleId, RoleToSaveDto role) throws NotFoundExceptionEntity;
    RoleDto findRoleById(Long roleId) throws NotFoundExceptionEntity;
    void removeRole(Long roleId);
    List<RoleDto> getAllRoles();
}
