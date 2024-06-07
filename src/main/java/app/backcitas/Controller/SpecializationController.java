package app.backcitas.Controller;

import app.backcitas.dto.specialization.SpecializationDto;
import app.backcitas.dto.specialization.SpecializationToSaveDto;
import app.backcitas.exception.NotAbleToDeleteException;
import app.backcitas.exception.NotFoundExceptionEntity;
import app.backcitas.models.Specialization;
import app.backcitas.services.specialization.SpecializationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/specializations")
@CrossOrigin(value = "http://localhost:5173")
public class SpecializationController {

    private final SpecializationService specializationService;

    @Autowired
    public SpecializationController(SpecializationService specializationService) {
        this.specializationService = specializationService;
    }

    @PostMapping
    public ResponseEntity<SpecializationDto> saveSpecialization(@RequestBody SpecializationToSaveDto specializationToSaveDto) {
        SpecializationDto savedSpecialization = specializationService.saveSpecialization(specializationToSaveDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedSpecialization);
    }

    @GetMapping
    public ResponseEntity<List<SpecializationDto>> getAllSpecializations() {
        List<SpecializationDto> specializations = specializationService.getAllSpecializations();
        return ResponseEntity.ok(specializations);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SpecializationDto> getSpecializationById(@PathVariable Long id) {
        try {
            SpecializationDto specializationDto = specializationService.findSpecializationById(id);
            return ResponseEntity.ok(specializationDto);
        } catch (NotFoundExceptionEntity e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<SpecializationDto> updateSpecialization(@PathVariable Long id, @RequestBody SpecializationToSaveDto specializationToSaveDto) {
        try {
            SpecializationDto updatedSpecialization = specializationService.updateSpecialization(id, specializationToSaveDto);
            return ResponseEntity.ok(updatedSpecialization);
        } catch (NotFoundExceptionEntity e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSpecialization(@PathVariable Long id) {
        try {
            specializationService.removeSpecialization(id);
            return ResponseEntity.noContent().build();
        } catch (NotAbleToDeleteException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
