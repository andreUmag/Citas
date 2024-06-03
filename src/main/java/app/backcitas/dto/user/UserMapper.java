package app.backcitas.dto.user;

import app.backcitas.models.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    User saveDtoToEntity(UserToSaveDto dto);
    User toEntity(UserDto dto);
    UserDto toDto(User entity);
}
