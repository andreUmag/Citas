package app.backcitas.services.Eps;

import app.backcitas.dto.EPS.EPSDto;
import app.backcitas.dto.EPS.EPSMapper;
import app.backcitas.repositories.EPSRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EpsServiceImpl implements EpsService{

    private final EPSRepository epsRepository;
    private EPSMapper epsMapper;

    @Autowired
    public EpsServiceImpl(EPSRepository epsRepository, EPSMapper epsMapper) {
        this.epsRepository = epsRepository;
        this.epsMapper = epsMapper;
    }

    @Override
    public List<EPSDto> getAllEps() {
        return epsRepository.findAll()
                .stream()
                .map(epsMapper::toDto)
                .toList();
    }
}
