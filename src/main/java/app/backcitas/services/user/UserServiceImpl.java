package app.backcitas.services.user;

import app.backcitas.dto.user.UserDto;
import app.backcitas.dto.user.UserMapper;
import app.backcitas.dto.user.UserToSaveDto;
import app.backcitas.exception.NotAbleToDeleteException;
import app.backcitas.exception.NotFoundExceptionEntity;
import app.backcitas.models.User;
import app.backcitas.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private UserMapper userMapper;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    @Override
    public UserDto saveUser(UserToSaveDto dto) {
        User user = userMapper.saveDtoToEntity(dto);
        return userMapper.toDto(userRepository.save(user));
    }

    @Override
    public UserDto updateUser(Long id, UserToSaveDto dto) throws NotFoundExceptionEntity {
        return userRepository.findById(id).map(user -> {
            user.setName(dto.name());
            user.setLastName(dto.lastName());
            user.setIdentityDocumentType(dto.identityDocumentType());
            user.setIdCard(dto.idCard());
            user.setEmail(dto.email());
            user.setPassword(dto.password());
            user.setSpecialization(dto.specialization());
            user.setRole(dto.role());
            return userMapper.toDto(userRepository.save(user));
        }).orElseThrow(() -> new NotFoundExceptionEntity("User not found."));
    }

    @Override
    public UserDto findUserById(Long id) throws NotFoundExceptionEntity {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new NotFoundExceptionEntity("User not found."));
        return userMapper.toDto(user);
    }

    @Override
    public void removeUser(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new NotAbleToDeleteException("User not found."));
        userRepository.delete(user);
    }

    @Override
    public List<UserDto> getAllUsers() {
        return userRepository.findAll()
                .stream()
                .map(userMapper::toDto)
                .toList();
    }
}
