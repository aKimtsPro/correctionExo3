package bstorm.akim.correctionExo3.business.mapper;

public interface Mapper<DTO, ENTITY> {

    DTO toDTO(ENTITY entity);
    ENTITY toEntity(DTO dto);

}
