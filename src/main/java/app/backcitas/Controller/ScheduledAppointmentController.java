package app.backcitas.Controller;


import app.backcitas.dto.scheduledAppointments.ScheduledAppointmentDto;
import app.backcitas.dto.scheduledAppointments.ScheduledAppointmentToSaveDto;
import app.backcitas.exception.NotAbleToDeleteException;
import app.backcitas.exception.NotFoundExceptionEntity;
import app.backcitas.services.scheduledAppointments.ScheduledAppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/scheduled_appointment")
@CrossOrigin(value = "http://localhost:5173")
public class ScheduledAppointmentController {

    private final ScheduledAppointmentService appointmentsAvailableService;

    @Autowired
    public ScheduledAppointmentController(ScheduledAppointmentService appointmentsAvailableService) {
        this.appointmentsAvailableService = appointmentsAvailableService;
    }

    @PostMapping
    public ResponseEntity<ScheduledAppointmentDto> saveAppointmentAvailable(@RequestBody ScheduledAppointmentToSaveDto appointmentsAvailableToSaveDto) {
        ScheduledAppointmentDto savedAppointmentAvailable = appointmentsAvailableService.saveScheduledAppointment(appointmentsAvailableToSaveDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedAppointmentAvailable);
    }

    @GetMapping
    public ResponseEntity<List<ScheduledAppointmentDto>> getAllAppointmentsAvailable() {
        List<ScheduledAppointmentDto> appointmentsAvailableList = appointmentsAvailableService.getAllScheduledAppointments();
        return ResponseEntity.ok(appointmentsAvailableList);
    }

    @GetMapping("/patient/{id}")
    public ResponseEntity<List<ScheduledAppointmentDto>> getAllUser(@PathVariable Long idPatient) {
        List<ScheduledAppointmentDto> appointmentsAvailableList = appointmentsAvailableService.findByIdUser(idPatient);
        return ResponseEntity.ok(appointmentsAvailableList);
    }


    @GetMapping("/{id}")
    public ResponseEntity<ScheduledAppointmentDto> getAppointmentAvailableById(@PathVariable Long id) {
        try {
            ScheduledAppointmentDto appointmentAvailableDto = appointmentsAvailableService.findScheduledAppointmentById(id);
            return ResponseEntity.ok(appointmentAvailableDto);
        } catch (NotFoundExceptionEntity e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<ScheduledAppointmentDto> updateAppointmentAvailable(@PathVariable Long id, @RequestBody ScheduledAppointmentToSaveDto appointmentsAvailableToSaveDto) {
        try {
            ScheduledAppointmentDto updatedAppointmentAvailable = appointmentsAvailableService.updateScheduledAppointment(id, appointmentsAvailableToSaveDto);
            return ResponseEntity.ok(updatedAppointmentAvailable);
        } catch (NotFoundExceptionEntity e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAppointmentAvailable(@PathVariable Long id) {
        try {
            appointmentsAvailableService.removeScheduledAppointment(id);
            return ResponseEntity.noContent().build();
        } catch (NotAbleToDeleteException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
