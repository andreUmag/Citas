package app.backcitas.services.appointmentsAvailable;

import app.backcitas.dto.appointmentsAvailable.AppointmentAvailableDto;

import app.backcitas.dto.appointmentsAvailable.AppointmentAvailableMapper;
import app.backcitas.dto.appointmentsAvailable.AppointmentAvailableToSaveDto;
import app.backcitas.exception.NotAbleToDeleteException;
import app.backcitas.exception.NotFoundExceptionEntity;
import app.backcitas.models.AppointmentAvailable;
import app.backcitas.repositories.AppointmentsAvailableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppointmentAvailableServiceImpl implements AppointmentAvailableService {

    private final AppointmentsAvailableRepository appointmentsAvailableRepository;
    private final AppointmentAvailableMapper appointmentsAvailableMapper;

    @Autowired
    public AppointmentAvailableServiceImpl(AppointmentsAvailableRepository appointmentsAvailableRepository, AppointmentAvailableMapper appointmentsAvailableMapper) {
        this.appointmentsAvailableRepository = appointmentsAvailableRepository;
        this.appointmentsAvailableMapper = appointmentsAvailableMapper;
    }

    @Override
    public AppointmentAvailableDto saveAppointmentAvailable(AppointmentAvailableToSaveDto dto) {
        AppointmentAvailable appointment = appointmentsAvailableMapper.saveDtoToEntity(dto);
        return appointmentsAvailableMapper.toDto(appointmentsAvailableRepository.save(appointment));
    }

    @Override
    public AppointmentAvailableDto updateAppointmentAvailable(Long id, AppointmentAvailableToSaveDto dto) throws NotFoundExceptionEntity {
        return appointmentsAvailableRepository.findById(id).map(appointment -> {
            appointment.setDateTime(dto.dateTime());
            appointment.setDoctor(dto.doctor());
            appointment.setAvailable(dto.available());
            return appointmentsAvailableMapper.toDto(appointmentsAvailableRepository.save(appointment));
        }).orElseThrow(() -> new NotFoundExceptionEntity("Appointment not found."));
    }

    @Override
    public AppointmentAvailableDto findAppointmentAvailableById(Long id) throws NotFoundExceptionEntity {
        AppointmentAvailable appointment = appointmentsAvailableRepository.findById(id)
                .orElseThrow(() -> new NotFoundExceptionEntity("Appointment not found."));
        return appointmentsAvailableMapper.toDto(appointment);
    }

    @Override
    public void removeAppointmentAvailable(Long id) {
        AppointmentAvailable appointment = appointmentsAvailableRepository.findById(id)
                .orElseThrow(() -> new NotAbleToDeleteException("Appointment not found."));
        appointmentsAvailableRepository.delete(appointment);
    }

    @Override
    public List<AppointmentAvailableDto> getAllAppointmentAvailable() {
        return appointmentsAvailableRepository.findAll()
                .stream()
                .map(appointmentsAvailableMapper::toDto)
                .toList();
    }

    @Override
    public List<AppointmentAvailableDto> findBySpecialization(String specialization) {
        return appointmentsAvailableRepository.findByDoctor_Specialization_Name(specialization)
                .stream()
                .map(appointmentsAvailableMapper::toDto)
                .toList();
    }
}