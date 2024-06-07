package app.backcitas.dto.EPS;

import app.backcitas.models.EPS;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-06-06T18:26:00-0500",
    comments = "version: 1.5.5.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.7.jar, environment: Java 17.0.10 (Oracle Corporation)"
)
@Component
public class EPSMapperImpl implements EPSMapper {

    @Override
    public EPS toEntity(EPSDto dto) {
        if ( dto == null ) {
            return null;
        }

        EPS ePS = new EPS();

        ePS.setId( dto.id() );
        ePS.setName( dto.name() );

        return ePS;
    }

    @Override
    public EPSDto toDto(EPS entity) {
        if ( entity == null ) {
            return null;
        }

        Long id = null;
        String name = null;

        id = entity.getId();
        name = entity.getName();

        EPSDto ePSDto = new EPSDto( id, name );

        return ePSDto;
    }
}
