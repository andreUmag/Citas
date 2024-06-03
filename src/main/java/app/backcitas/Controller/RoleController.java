package app.backcitas.Controller;

import app.backcitas.dto.role.RoleDto;
import app.backcitas.dto.role.RoleToSaveDto;
import app.backcitas.exception.NotAbleToDeleteException;
import app.backcitas.exception.NotFoundExceptionEntity;
import app.backcitas.services.role.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/roles")
public class RoleController {

    private final RoleService roleService;

    @Autowired
    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }

    @PostMapping
    public ResponseEntity<RoleDto> saveRole(@RequestBody RoleToSaveDto roleToSaveDto) {
        RoleDto savedRole = roleService.saveRole(roleToSaveDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedRole);
    }

    @GetMapping
    public ResponseEntity<List<RoleDto>> getAllRoles() {
        List<RoleDto> roles = roleService.getAllRoles();
        return ResponseEntity.ok(roles);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RoleDto> getRoleById(@PathVariable Long id) {
        try {
            RoleDto roleDto = roleService.findRoleById(id);
            return ResponseEntity.ok(roleDto);
        } catch (NotFoundExceptionEntity e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<RoleDto> updateRole(@PathVariable Long id, @RequestBody RoleToSaveDto roleToSaveDto) {
        try {
            RoleDto updatedRole = roleService.updateRole(id, roleToSaveDto);
            return ResponseEntity.ok(updatedRole);
        } catch (NotFoundExceptionEntity e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRole(@PathVariable Long id) {
        try {
            roleService.removeRole(id);
            return ResponseEntity.noContent().build();
        } catch (NotAbleToDeleteException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
