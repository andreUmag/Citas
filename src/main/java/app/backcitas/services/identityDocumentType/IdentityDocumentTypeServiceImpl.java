package app.backcitas.services.identityDocumentType;

import app.backcitas.dto.IdentityDocumentType.IdentityDocumentTypeDto;
import app.backcitas.dto.IdentityDocumentType.IdentityDocumentTypeMapper;
import app.backcitas.repositories.IdentityDocumentTypeRepository;
import app.backcitas.repositories.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IdentityDocumentTypeServiceImpl implements IdentityDocumentTypeService{

    private final IdentityDocumentTypeRepository identityDocumentTypeRepository;
    private IdentityDocumentTypeMapper identityDocumentTypeMapper;

    @Autowired
    public IdentityDocumentTypeServiceImpl(IdentityDocumentTypeRepository identityDocumentTypeRepository, IdentityDocumentTypeMapper identityDocumentTypeMapper) {
        this.identityDocumentTypeRepository = identityDocumentTypeRepository;
        this.identityDocumentTypeMapper = identityDocumentTypeMapper;
    }

    @Override
    public List<IdentityDocumentTypeDto> getAllIdentityTypes() {
        return identityDocumentTypeRepository.findAll()
                .stream()
                .map(identityDocumentTypeMapper::toDto)
                .toList();
    }
}
