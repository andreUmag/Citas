package app.backcitas.dto.role;

import app.backcitas.models.Role;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface RoleMapper {
    RoleMapper INSTANCE = Mappers.getMapper(RoleMapper.class);

    Role saveDtoToEntity(RoleToSaveDto dto);
    Role toEntity(RoleDto dto);
    RoleDto toDto(Role entity);
}
