package app.backcitas.dtos.user;

import app.backcitas.models.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    UserDto userEntityToUserDto(User user);

    User userDtoToUserEntity(UserDto userDto);
}
