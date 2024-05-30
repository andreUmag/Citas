package app.backcitas.dtos.location;

import app.backcitas.models.Location;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface LocationMapper {

    LocationMapper INSTANCE = Mappers.getMapper(LocationMapper.class);

    LocationDto locationEntityToLocationDto(Location location);

    Location locationDtoToLocationEntity(LocationDto locationDto);
}
