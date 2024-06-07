package app.backcitas.services.identityDocumentType;

import app.backcitas.dto.IdentityDocumentType.IdentityDocumentTypeDto;

import java.util.List;

public interface IdentityDocumentTypeService {
    List<IdentityDocumentTypeDto> getAllIdentityTypes();
}
