package app.backcitas.services.specialization;

import app.backcitas.dto.specialization.SpecializationDto;
import app.backcitas.dto.specialization.SpecializationMapper;
import app.backcitas.dto.specialization.SpecializationToSaveDto;
import app.backcitas.exception.NotAbleToDeleteException;
import app.backcitas.exception.NotFoundExceptionEntity;
import app.backcitas.models.Specialization;
import app.backcitas.repositories.SpecializationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SpecializationServiceImpl implements SpecializationService {

    private final SpecializationRepository specializationRepository;
    private SpecializationMapper specializationMapper;

    @Autowired
    public SpecializationServiceImpl(SpecializationRepository specializationRepository, SpecializationMapper specializationMapper) {
        this.specializationRepository = specializationRepository;
        this.specializationMapper = specializationMapper;
    }

    @Override
    public SpecializationDto saveSpecialization(SpecializationToSaveDto dto) {
        Specialization specialization = specializationMapper.saveDtoToEntity(dto);
        return specializationMapper.toDto(specializationRepository.save(specialization));
    }

    @Override
    public SpecializationDto updateSpecialization(Long id, SpecializationToSaveDto dto) throws NotFoundExceptionEntity {
        return specializationRepository.findById(id).map(specialization -> {
            specialization.setName(dto.name());
            return specializationMapper.toDto(specializationRepository.save(specialization));
        }).orElseThrow(() -> new NotFoundExceptionEntity("Specialization not found."));
    }

    @Override
    public SpecializationDto findSpecializationById(Long id) throws NotFoundExceptionEntity {
        Specialization specialization = specializationRepository.findById(id)
                .orElseThrow(() -> new NotFoundExceptionEntity("Specialization not found."));
        return specializationMapper.toDto(specialization);
    }

    @Override
    public void removeSpecialization(Long id) {
        Specialization specialization = specializationRepository.findById(id)
                .orElseThrow(() -> new NotAbleToDeleteException("Specialization not found."));
        specializationRepository.delete(specialization);
    }

    @Override
    public List<SpecializationDto> getAllSpecializations() {
        return specializationRepository.findAll()
                .stream()
                .map(specializationMapper::toDto)
                .toList();
    }
}
