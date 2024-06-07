package app.backcitas.dto.status;

import app.backcitas.models.Status;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-06-06T18:26:01-0500",
    comments = "version: 1.5.5.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.7.jar, environment: Java 17.0.10 (Oracle Corporation)"
)
@Component
public class StatusMapperImpl implements StatusMapper {

    @Override
    public Status toEntity(StatusDto dto) {
        if ( dto == null ) {
            return null;
        }

        Status status = new Status();

        status.setId( dto.id() );
        status.setName( dto.name() );

        return status;
    }

    @Override
    public StatusDto toDto(Status entity) {
        if ( entity == null ) {
            return null;
        }

        Long id = null;
        String name = null;

        id = entity.getId();
        name = entity.getName();

        StatusDto statusDto = new StatusDto( id, name );

        return statusDto;
    }
}
