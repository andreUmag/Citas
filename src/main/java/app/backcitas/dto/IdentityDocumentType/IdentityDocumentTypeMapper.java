package app.backcitas.dto.IdentityDocumentType;

import app.backcitas.models.IdentityDocumentType;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface IdentityDocumentTypeMapper {
    IdentityDocumentTypeMapper INSTANCE = Mappers.getMapper(IdentityDocumentTypeMapper.class);

    IdentityDocumentType toEntity(IdentityDocumentTypeDto dto);
    IdentityDocumentTypeDto toDto(IdentityDocumentType entity);
}
