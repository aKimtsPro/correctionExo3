package bstorm.akim.correctionExo3.business.mapper;

import bstorm.akim.correctionExo3.business.dto.StudentSectionDTO;
import bstorm.akim.correctionExo3.data_access.entities.Section;
import bstorm.akim.correctionExo3.data_access.repository.SectionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SmolSectionMapper implements Mapper<StudentSectionDTO, Section> {

    @Autowired
    private SectionRepository repo;

    @Override
    public StudentSectionDTO toDTO(Section section) {
        if(section == null)
            return null;

        return new StudentSectionDTO(
                section.getId(),
                section.getName()
        );
    }

    @Override
    public Section toEntity(StudentSectionDTO smolSectionDTO) {
        if(smolSectionDTO == null)
            return null;

        return repo.getOne( smolSectionDTO.getId() );
    }
}
