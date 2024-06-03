package app.backcitas.services.scheduledAppointments;

import app.backcitas.dto.scheduledAppointments.ScheduledAppointmentDto;
import app.backcitas.dto.scheduledAppointments.ScheduledAppointmentMapper;
import app.backcitas.dto.scheduledAppointments.ScheduledAppointmentToSaveDto;
import app.backcitas.exception.NotAbleToDeleteException;
import app.backcitas.exception.NotFoundExceptionEntity;
import app.backcitas.models.ScheduledAppointments;
import app.backcitas.repositories.ScheduledAppointmentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScheduledAppointmentServiceImpl implements ScheduledAppointmentService {

    private final ScheduledAppointmentsRepository scheduledAppointmentRepository;
    private ScheduledAppointmentMapper scheduledAppointmentMapper;

    @Autowired
    public ScheduledAppointmentServiceImpl(ScheduledAppointmentsRepository scheduledAppointmentRepository, ScheduledAppointmentMapper scheduledAppointmentMapper) {
        this.scheduledAppointmentRepository = scheduledAppointmentRepository;
        this.scheduledAppointmentMapper = scheduledAppointmentMapper;
    }

    @Override
    public ScheduledAppointmentDto saveScheduledAppointment(ScheduledAppointmentToSaveDto dto) {
        ScheduledAppointments scheduledAppointment = scheduledAppointmentMapper.saveDtoToEntity(dto);
        return scheduledAppointmentMapper.toDto(scheduledAppointmentRepository.save(scheduledAppointment));
    }

    @Override
    public ScheduledAppointmentDto updateScheduledAppointment(Long id, ScheduledAppointmentToSaveDto dto) throws NotFoundExceptionEntity {
        return scheduledAppointmentRepository.findById(id).map(scheduledAppointment -> {
            scheduledAppointment.setDoctor(dto.doctor());
            scheduledAppointment.setPatient(dto.patient());
            scheduledAppointment.setDateTime(dto.dateTime());
            scheduledAppointment.setStatus(dto.status());
            return scheduledAppointmentMapper.toDto(scheduledAppointmentRepository.save(scheduledAppointment));
        }).orElseThrow(() -> new NotFoundExceptionEntity("Scheduled appointment not found."));
    }

    @Override
    public ScheduledAppointmentDto findScheduledAppointmentById(Long id) throws NotFoundExceptionEntity {
        ScheduledAppointments scheduledAppointment = scheduledAppointmentRepository.findById(id)
                .orElseThrow(() -> new NotFoundExceptionEntity("Scheduled appointment not found."));
        return scheduledAppointmentMapper.toDto(scheduledAppointment);
    }

    @Override
    public void removeScheduledAppointment(Long id) {
        ScheduledAppointments scheduledAppointment = scheduledAppointmentRepository.findById(id)
                .orElseThrow(() -> new NotAbleToDeleteException("Scheduled appointment not found."));
        scheduledAppointmentRepository.delete(scheduledAppointment);
    }

    @Override
    public List<ScheduledAppointmentDto> getAllScheduledAppointments() {
        return scheduledAppointmentRepository.findAll()
                .stream()
                .map(scheduledAppointmentMapper::toDto)
                .toList();
    }
}
