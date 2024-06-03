package app.backcitas.Controller;

import app.backcitas.dto.user.UserDto;
import app.backcitas.dto.user.UserToSaveDto;
import app.backcitas.exception.NotAbleToDeleteException;
import app.backcitas.exception.NotFoundExceptionEntity;
import app.backcitas.services.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<UserDto> saveUser(@RequestBody UserToSaveDto userToSaveDto) {
        UserDto savedUser = userService.saveUser(userToSaveDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedUser);
    }

    @GetMapping
    public ResponseEntity<List<UserDto>> getAllUsers() {
        List<UserDto> users = userService.getAllUsers();
        return ResponseEntity.ok(users);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDto> getUserById(@PathVariable Long id) {
        try {
            UserDto userDto = userService.findUserById(id);
            return ResponseEntity.ok(userDto);
        } catch (NotFoundExceptionEntity e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserDto> updateUser(@PathVariable Long id, @RequestBody UserToSaveDto userToSaveDto) {
        try {
            UserDto updatedUser = userService.updateUser(id, userToSaveDto);
            return ResponseEntity.ok(updatedUser);
        } catch (NotFoundExceptionEntity e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        try {
            userService.removeUser(id);
            return ResponseEntity.noContent().build();
        } catch (NotAbleToDeleteException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
