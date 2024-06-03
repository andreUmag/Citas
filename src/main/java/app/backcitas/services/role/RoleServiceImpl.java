package app.backcitas.services.role;

import app.backcitas.dto.role.RoleDto;
import app.backcitas.dto.role.RoleMapper;
import app.backcitas.dto.role.RoleToSaveDto;
import app.backcitas.exception.NotAbleToDeleteException;
import app.backcitas.exception.NotFoundExceptionEntity;
import app.backcitas.models.Role;
import app.backcitas.repositories.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;
    private RoleMapper roleMapper;

    @Autowired
    public RoleServiceImpl(RoleRepository roleRepository, RoleMapper roleMapper) {
        this.roleRepository = roleRepository;
        this.roleMapper = roleMapper;
    }

    @Override
    public RoleDto saveRole(RoleToSaveDto roleToSaveDto) {
        Role role = roleMapper.saveDtoToEntity(roleToSaveDto);
        return roleMapper.toDto(roleRepository.save(role));
    }

    @Override
    public RoleDto updateRole(Long roleId, RoleToSaveDto roleDto) throws NotFoundExceptionEntity {
        return roleRepository.findById(roleId).map(role ->{
            role.setName(roleDto.name());

            Role roleSaved = roleRepository.save(role);

            return roleMapper.toDto(roleSaved);
        }).orElseThrow(()->new NotFoundExceptionEntity("Role not found."));
    }

    @Override
    public RoleDto findRoleById(Long roleId) throws NotFoundExceptionEntity {
        Role role = roleRepository.findById(roleId)
                .orElseThrow(() -> new NotFoundExceptionEntity("Role not found."));
        return roleMapper.toDto(role);
    }

    @Override
    public void removeRole(Long roleId) {
        Role role = roleRepository.findById(roleId)
                .orElseThrow(() -> new NotAbleToDeleteException("Role not found."));
        roleRepository.delete(role);
    }

    @Override
    public List<RoleDto> getAllRoles() {
        return roleRepository.findAll()
                .stream()
                .map(roleMapper::toDto)
                .toList();
    }
}
