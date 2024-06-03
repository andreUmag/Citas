package app.backcitas.dto.appointmentsAvailable;

import app.backcitas.Enum.IdentityDocumentType;
import app.backcitas.dto.role.RoleDto;
import app.backcitas.dto.specialization.SpecializationDto;
import app.backcitas.dto.user.UserDto;
import app.backcitas.models.AppointmentAvailable;
import app.backcitas.models.Role;
import app.backcitas.models.Specialization;
import app.backcitas.models.User;
import java.time.LocalDateTime;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-06-03T18:16:36-0500",
    comments = "version: 1.5.5.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.7.jar, environment: Java 17.0.10 (Oracle Corporation)"
)
@Component
public class AppointmentAvailableMapperImpl implements AppointmentAvailableMapper {

    @Override
    public AppointmentAvailable toEntity(AppointmentAvailableDto dto) {
        if ( dto == null ) {
            return null;
        }

        AppointmentAvailable appointmentAvailable = new AppointmentAvailable();

        appointmentAvailable.setId( dto.id() );
        appointmentAvailable.setDateTime( dto.dateTime() );
        appointmentAvailable.setDoctor( userDtoToUser( dto.doctor() ) );
        appointmentAvailable.setAvailable( dto.available() );

        return appointmentAvailable;
    }

    @Override
    public AppointmentAvailable saveDtoToEntity(AppointmentAvailableToSaveDto dto) {
        if ( dto == null ) {
            return null;
        }

        AppointmentAvailable appointmentAvailable = new AppointmentAvailable();

        appointmentAvailable.setId( dto.id() );
        appointmentAvailable.setDateTime( dto.dateTime() );
        appointmentAvailable.setDoctor( dto.doctor() );
        appointmentAvailable.setAvailable( dto.available() );

        return appointmentAvailable;
    }

    @Override
    public AppointmentAvailableDto toDto(AppointmentAvailable entity) {
        if ( entity == null ) {
            return null;
        }

        Long id = null;
        LocalDateTime dateTime = null;
        UserDto doctor = null;
        Boolean available = null;

        id = entity.getId();
        dateTime = entity.getDateTime();
        doctor = userToUserDto( entity.getDoctor() );
        available = entity.getAvailable();

        AppointmentAvailableDto appointmentAvailableDto = new AppointmentAvailableDto( id, dateTime, doctor, available );

        return appointmentAvailableDto;
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

    protected User userDtoToUser(UserDto userDto) {
        if ( userDto == null ) {
            return null;
        }

        User.UserBuilder user = User.builder();

        user.id( userDto.id() );
        user.name( userDto.name() );
        user.lastName( userDto.lastName() );
        user.identityDocumentType( userDto.identityDocumentType() );
        user.idCard( userDto.idCard() );
        user.email( userDto.email() );
        user.password( userDto.password() );
        user.specialization( specializationDtoToSpecialization( userDto.specialization() ) );
        user.role( roleDtoToRole( userDto.role() ) );

        return user.build();
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

    protected UserDto userToUserDto(User user) {
        if ( user == null ) {
            return null;
        }

        Long id = null;
        String name = null;
        String lastName = null;
        IdentityDocumentType identityDocumentType = null;
        String idCard = null;
        String email = null;
        String password = null;
        SpecializationDto specialization = null;
        RoleDto role = null;

        id = user.getId();
        name = user.getName();
        lastName = user.getLastName();
        identityDocumentType = user.getIdentityDocumentType();
        idCard = user.getIdCard();
        email = user.getEmail();
        password = user.getPassword();
        specialization = specializationToSpecializationDto( user.getSpecialization() );
        role = roleToRoleDto( user.getRole() );

        UserDto userDto = new UserDto( id, name, lastName, identityDocumentType, idCard, email, password, specialization, role );

        return userDto;
    }
}