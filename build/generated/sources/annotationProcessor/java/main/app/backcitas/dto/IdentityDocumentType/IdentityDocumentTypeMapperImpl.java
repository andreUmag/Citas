package app.backcitas.dto.IdentityDocumentType;

import app.backcitas.models.IdentityDocumentType;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-06-06T18:26:01-0500",
    comments = "version: 1.5.5.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.7.jar, environment: Java 17.0.10 (Oracle Corporation)"
)
@Component
public class IdentityDocumentTypeMapperImpl implements IdentityDocumentTypeMapper {

    @Override
    public IdentityDocumentType toEntity(IdentityDocumentTypeDto dto) {
        if ( dto == null ) {
            return null;
        }

        IdentityDocumentType identityDocumentType = new IdentityDocumentType();

        identityDocumentType.setId( dto.id() );
        identityDocumentType.setName( dto.name() );

        return identityDocumentType;
    }

    @Override
    public IdentityDocumentTypeDto toDto(IdentityDocumentType entity) {
        if ( entity == null ) {
            return null;
        }

        Long id = null;
        String name = null;

        id = entity.getId();
        name = entity.getName();

        IdentityDocumentTypeDto identityDocumentTypeDto = new IdentityDocumentTypeDto( id, name );

        return identityDocumentTypeDto;
    }
}
