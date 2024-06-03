package app.backcitas.dto.specialization;

import app.backcitas.models.Specialization;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-06-03T17:48:56-0500",
    comments = "version: 1.5.5.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.7.jar, environment: Java 17.0.10 (Oracle Corporation)"
)
@Component
public class SpecializationMapperImpl implements SpecializationMapper {

    @Override
    public Specialization toEntity(SpecializationDto specializationDto) {
        if ( specializationDto == null ) {
            return null;
        }

        Specialization specialization = new Specialization();

        specialization.setId( specializationDto.id() );
        specialization.setName( specializationDto.name() );

        return specialization;
    }

    @Override
    public SpecializationDto toDto(Specialization specialization) {
        if ( specialization == null ) {
            return null;
        }

        Long id = null;
        String name = null;

        id = specialization.getId();
        name = specialization.getName();

        SpecializationDto specializationDto = new SpecializationDto( id, name );

        return specializationDto;
    }

    @Override
    public Specialization saveDtoToEntity(SpecializationToSaveDto specializationToSaveDto) {
        if ( specializationToSaveDto == null ) {
            return null;
        }

        Specialization specialization = new Specialization();

        specialization.setId( specializationToSaveDto.id() );
        specialization.setName( specializationToSaveDto.name() );

        return specialization;
    }
}
