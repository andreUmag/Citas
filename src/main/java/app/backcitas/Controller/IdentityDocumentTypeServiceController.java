package app.backcitas.Controller;

import app.backcitas.dto.IdentityDocumentType.IdentityDocumentTypeDto;
import app.backcitas.services.identityDocumentType.IdentityDocumentTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/document-type")
@CrossOrigin(value = "http://localhost:5173")
public class IdentityDocumentTypeServiceController {

    private final IdentityDocumentTypeService identityDocumentTypeService;

    @Autowired
    public IdentityDocumentTypeServiceController(IdentityDocumentTypeService identityDocumentTypeService) {
        this.identityDocumentTypeService = identityDocumentTypeService;
    }

    @GetMapping
    public ResponseEntity<List<IdentityDocumentTypeDto>> getAllIdentityTypes() {
        List<IdentityDocumentTypeDto> roles = identityDocumentTypeService.getAllIdentityTypes();
        return ResponseEntity.ok(roles);
    }
}
