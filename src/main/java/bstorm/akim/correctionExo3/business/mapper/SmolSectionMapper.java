package bstorm.akim.correctionExo3.business.mapper;

import bstorm.akim.correctionExo3.business.dto.StudentSectionDTO;
import bstorm.akim.correctionExo3.data_access.entities.Section;
import org.springframework.stereotype.Component;

@Component
public class SmolSectionMapper implements Mapper<StudentSectionDTO, Section> {
    @Override
    public StudentSectionDTO toDTO(Section section) {
        if(section == null)
            return null;

        return new StudentSectionDTO(
                section.getId(),
                section.getName(),
                section.getDelegateId()
        );
    }

    @Override
    public Section toEntity(StudentSectionDTO smolSectionDTO) {
        if(smolSectionDTO == null)
            return null;

        Section section = new Section();
        section.setName(smolSectionDTO.getName());
        section.setId(smolSectionDTO.getId());
        section.setDelegateId(smolSectionDTO.getDelegateId());

        return section;
    }
}
