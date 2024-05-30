package app.backcitas.dtos.role;

import app.backcitas.models.Role;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface RoleMapper {
    
    RoleMapper INSTANCE = Mappers.getMapper(RoleMapper.class);

    RoleDto roleEntityToRoleDto(Role role);

    Role roleDtoToRoleEntity(RoleDto roleDto);
}
