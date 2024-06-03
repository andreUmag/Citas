package app.backcitas.services.user;

import app.backcitas.dto.user.UserDto;
import app.backcitas.dto.user.UserToSaveDto;
import app.backcitas.exception.NotFoundExceptionEntity;

import java.util.List;

public interface UserService {
    UserDto saveUser(UserToSaveDto user);
    UserDto updateUser(Long userId, UserToSaveDto user) throws NotFoundExceptionEntity;
    UserDto findUserById(Long userId) throws NotFoundExceptionEntity;
    void removeUser(Long userId);
    List<UserDto> getAllUsers();

}
