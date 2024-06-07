package app.backcitas.dto.user;

import app.backcitas.dto.IdentityDocumentType.IdentityDocumentTypeDto;
import app.backcitas.dto.role.RoleDto;
import app.backcitas.dto.specialization.SpecializationDto;
import app.backcitas.models.Role;
import app.backcitas.models.Specialization;
import app.backcitas.models.User;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-06-06T22:09:53-0500",
    comments = "version: 1.5.5.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.7.jar, environment: Java 17.0.10 (Oracle Corporation)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public User saveDtoToEntity(UserToSaveDto dto) {
        if ( dto == null ) {
            return null;
        }

        User.UserBuilder user = User.builder();

        user.name( dto.name() );
        user.lastName( dto.lastName() );
        user.idCard( dto.idCard() );
        user.email( dto.email() );
        user.password( dto.password() );
        user.specialization( dto.specialization() );
        user.role( dto.role() );

        return user.build();
    }

    @Override
    public User toEntity(UserDto dto) {
        if ( dto == null ) {
            return null;
        }

        User.UserBuilder user = User.builder();

        user.id( dto.id() );
        user.name( dto.name() );
        user.lastName( dto.lastName() );
        user.idCard( dto.idCard() );
        user.email( dto.email() );
        user.password( dto.password() );
        user.specialization( specializationDtoToSpecialization( dto.specialization() ) );
        user.role( roleDtoToRole( dto.role() ) );

        return user.build();
    }

    @Override
    public UserDto toDto(User entity) {
        if ( entity == null ) {
            return null;
        }

        Long id = null;
        String name = null;
        String lastName = null;
        String idCard = null;
        String email = null;
        String password = null;
        SpecializationDto specialization = null;
        RoleDto role = null;

        id = entity.getId();
        name = entity.getName();
        lastName = entity.getLastName();
        idCard = entity.getIdCard();
        email = entity.getEmail();
        password = entity.getPassword();
        specialization = specializationToSpecializationDto( entity.getSpecialization() );
        role = roleToRoleDto( entity.getRole() );

        IdentityDocumentTypeDto identityDocumentType = null;

        UserDto userDto = new UserDto( id, name, lastName, identityDocumentType, idCard, email, password, specialization, role );

        return userDto;
    }

    protected Specialization specializationDtoToSpecialization(SpecializationDto specializationDto) {
        if ( specializationDto == null ) {
            return null;
        }

        Specialization specialization = new Specialization();

        specialization.setId( specializationDto.id() );
        specialization.setName( specializationDto.name() );

        return specialization;
    }

    protected Role roleDtoToRole(RoleDto roleDto) {
        if ( roleDto == null ) {
            return null;
        }

        Role role = new Role();

        role.setId( roleDto.id() );
        role.setName( roleDto.name() );

        return role;
    }

    protected SpecializationDto specializationToSpecializationDto(Specialization specialization) {
        if ( specialization == null ) {
            return null;
        }

        Long id = null;
        String name = null;

        id = specialization.getId();
        name = specialization.getName();

        SpecializationDto specializationDto = new SpecializationDto( id, name );

        return specializationDto;
    }

    protected RoleDto roleToRoleDto(Role role) {
        if ( role == null ) {
            return null;
        }

        Long id = null;
        String name = null;

        id = role.getId();
        name = role.getName();

        RoleDto roleDto = new RoleDto( id, name );

        return roleDto;
    }
}
