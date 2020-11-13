package bstorm.akim.correctionExo3.business.mapper;

import bstorm.akim.correctionExo3.business.dto.SectionDTO;
import bstorm.akim.correctionExo3.business.dto.StudentDTO;
import bstorm.akim.correctionExo3.data_access.entities.Section;
import bstorm.akim.correctionExo3.data_access.entities.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class SectionMapper implements Mapper<SectionDTO, Section> {

    @Autowired
    private Mapper<StudentDTO, Student> mapper;

    @Override
    public SectionDTO toDTO(Section section) {
        return new SectionDTO(
                section.getId(),
                section.getName(),
                section.getDelegateId(),
                section.getStudents().stream()
                        .map(mapper::toDTO)// TODO : aide du mapper de student
                        .collect(Collectors.toList())
        );
    }

    @Override
    public Section toEntity(SectionDTO sectionDTO) {
        Section section = new Section();

        section.setId(sectionDTO.getId());
        section.setName(sectionDTO.getName());
        section.setDelegateId(sectionDTO.getDelegateId());
        section.setStudents(
                sectionDTO.getStudents().stream()
                        .map(mapper::toEntity) // TODO : aide du mapper de student
                        .collect(Collectors.toList()));

        return section;
    }
}
