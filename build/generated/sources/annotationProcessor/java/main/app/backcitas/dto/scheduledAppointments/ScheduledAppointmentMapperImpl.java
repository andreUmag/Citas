package app.backcitas.dto.scheduledAppointments;

import app.backcitas.Enum.IdentityDocumentType;
import app.backcitas.Enum.Status;
import app.backcitas.dto.role.RoleDto;
import app.backcitas.dto.specialization.SpecializationDto;
import app.backcitas.dto.user.UserDto;
import app.backcitas.models.Role;
import app.backcitas.models.ScheduledAppointments;
import app.backcitas.models.Specialization;
import app.backcitas.models.User;
import java.time.LocalDateTime;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-06-03T18:16:37-0500",
    comments = "version: 1.5.5.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.7.jar, environment: Java 17.0.10 (Oracle Corporation)"
)
@Component
public class ScheduledAppointmentMapperImpl implements ScheduledAppointmentMapper {

    @Override
    public ScheduledAppointments saveDtoToEntity(ScheduledAppointmentToSaveDto scheduledAppointmentToSaveDto) {
        if ( scheduledAppointmentToSaveDto == null ) {
            return null;
        }

        ScheduledAppointments scheduledAppointments = new ScheduledAppointments();

        scheduledAppointments.setId( scheduledAppointmentToSaveDto.id() );
        scheduledAppointments.setDoctor( scheduledAppointmentToSaveDto.doctor() );
        scheduledAppointments.setPatient( scheduledAppointmentToSaveDto.patient() );
        scheduledAppointments.setDateTime( scheduledAppointmentToSaveDto.dateTime() );
        scheduledAppointments.setStatus( scheduledAppointmentToSaveDto.status() );

        return scheduledAppointments;
    }

    @Override
    public ScheduledAppointmentToSaveDto toEntity(ScheduledAppointmentDto scheduledAppointmentDto) {
        if ( scheduledAppointmentDto == null ) {
            return null;
        }

        Long id = null;
        User doctor = null;
        User patient = null;
        LocalDateTime dateTime = null;
        Status status = null;

        id = scheduledAppointmentDto.id();
        doctor = userDtoToUser( scheduledAppointmentDto.doctor() );
        patient = userDtoToUser( scheduledAppointmentDto.patient() );
        dateTime = scheduledAppointmentDto.dateTime();
        status = scheduledAppointmentDto.status();

        ScheduledAppointmentToSaveDto scheduledAppointmentToSaveDto = new ScheduledAppointmentToSaveDto( id, doctor, patient, dateTime, status );

        return scheduledAppointmentToSaveDto;
    }

    @Override
    public ScheduledAppointmentDto toDto(ScheduledAppointments scheduledAppointments) {
        if ( scheduledAppointments == null ) {
            return null;
        }

        Long id = null;
        UserDto doctor = null;
        UserDto patient = null;
        LocalDateTime dateTime = null;
        Status status = null;

        id = scheduledAppointments.getId();
        doctor = userToUserDto( scheduledAppointments.getDoctor() );
        patient = userToUserDto( scheduledAppointments.getPatient() );
        dateTime = scheduledAppointments.getDateTime();
        status = scheduledAppointments.getStatus();

        ScheduledAppointmentDto scheduledAppointmentDto = new ScheduledAppointmentDto( id, doctor, patient, dateTime, status );

        return scheduledAppointmentDto;
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
