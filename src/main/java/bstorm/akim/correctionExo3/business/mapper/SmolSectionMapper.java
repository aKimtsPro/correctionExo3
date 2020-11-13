package bstorm.akim.correctionExo3.business.mapper;

import bstorm.akim.correctionExo3.business.dto.SmolSectionDTO;
import bstorm.akim.correctionExo3.data_access.entities.Section;
import org.springframework.stereotype.Component;

@Component
public class SmolSectionMapper implements Mapper<SmolSectionDTO, Section> {
    @Override
    public SmolSectionDTO toDTO(Section section) {
        if(section == null)
            return null;

        return new SmolSectionDTO(
                section.getId(),
                section.getName(),
                section.getDelegateId()
        );
    }

    @Override
    public Section toEntity(SmolSectionDTO smolSectionDTO) {
        if(smolSectionDTO == null)
            return null;

        Section section = new Section();
        section.setName(smolSectionDTO.getName());
        section.setId(smolSectionDTO.getId());
        section.setDelegateId(smolSectionDTO.getDelegateId());

        return section;
    }
}
