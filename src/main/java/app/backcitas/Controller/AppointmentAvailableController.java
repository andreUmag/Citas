package app.backcitas.Controller;

import app.backcitas.dto.appointmentsAvailable.AppointmentAvailableDto;
import app.backcitas.dto.appointmentsAvailable.AppointmentAvailableToSaveDto;
import app.backcitas.exception.NotAbleToDeleteException;
import app.backcitas.exception.NotFoundExceptionEntity;
import app.backcitas.services.appointmentsAvailable.AppointmentAvailableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/appointments-available")
@CrossOrigin(value = "http://localhost:5173")
public class AppointmentAvailableController {

    private final AppointmentAvailableService appointmentsAvailableService;

    @Autowired
    public AppointmentAvailableController(AppointmentAvailableService appointmentsAvailableService) {
        this.appointmentsAvailableService = appointmentsAvailableService;
    }

    @PostMapping
    public ResponseEntity<AppointmentAvailableDto> saveAppointmentAvailable(@RequestBody AppointmentAvailableToSaveDto appointmentsAvailableToSaveDto) {
        AppointmentAvailableDto savedAppointmentAvailable = appointmentsAvailableService.saveAppointmentAvailable(appointmentsAvailableToSaveDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedAppointmentAvailable);
    }

    @GetMapping
    public ResponseEntity<List<AppointmentAvailableDto>> getAllAppointmentsAvailable() {
        List<AppointmentAvailableDto> appointmentsAvailableList = appointmentsAvailableService.getAllAppointmentAvailable();
        return ResponseEntity.ok(appointmentsAvailableList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AppointmentAvailableDto> getAppointmentAvailableById(@PathVariable Long id) {
        try {
            AppointmentAvailableDto appointmentAvailableDto = appointmentsAvailableService.findAppointmentAvailableById(id);
            return ResponseEntity.ok(appointmentAvailableDto);
        } catch (NotFoundExceptionEntity e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/specialization/{specialization}")
    public ResponseEntity<List<AppointmentAvailableDto>> findBySpecialization(@PathVariable("specialization") String specialization) {
        List<AppointmentAvailableDto> appointmentAvailableDto = appointmentsAvailableService.findBySpecialization(specialization);
        return ResponseEntity.ok(appointmentAvailableDto);
    }
    
    

    @PutMapping("/{id}")
    public ResponseEntity<AppointmentAvailableDto> updateAppointmentAvailable(@PathVariable Long id, @RequestBody AppointmentAvailableToSaveDto appointmentsAvailableToSaveDto) {
        try {
            AppointmentAvailableDto updatedAppointmentAvailable = appointmentsAvailableService.updateAppointmentAvailable(id, appointmentsAvailableToSaveDto);
            return ResponseEntity.ok(updatedAppointmentAvailable);
        } catch (NotFoundExceptionEntity e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAppointmentAvailable(@PathVariable Long id) {
        try {
            appointmentsAvailableService.removeAppointmentAvailable(id);
            return ResponseEntity.noContent().build();
        } catch (NotAbleToDeleteException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
