package app.backcitas.services.specialization;

import app.backcitas.dto.specialization.SpecializationDto;
import app.backcitas.dto.specialization.SpecializationToSaveDto;
import app.backcitas.exception.NotFoundExceptionEntity;

import java.util.List;

public interface SpecializationService {
    SpecializationDto saveSpecialization(SpecializationToSaveDto specialization);
    SpecializationDto updateSpecialization(Long specializationId, SpecializationToSaveDto specialization) throws NotFoundExceptionEntity;
    SpecializationDto findSpecializationById(Long specializationId) throws NotFoundExceptionEntity;
    void removeSpecialization(Long specializationId);
    List<SpecializationDto> getAllSpecializations();

}
