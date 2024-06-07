package app.backcitas.Controller;

import app.backcitas.dto.EPS.EPSDto;
import app.backcitas.services.Eps.EpsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/eps")
@CrossOrigin(value = "http://localhost:5173")
public class EpsController {

    private final EpsService epsService;

    @Autowired
    public EpsController(EpsService epsService) {
        this.epsService = epsService;
    }

    @GetMapping
    public ResponseEntity<List<EPSDto>> getAllEps() {
        List<EPSDto> roles = epsService.getAllEps();
        return ResponseEntity.ok(roles);
    }
}
