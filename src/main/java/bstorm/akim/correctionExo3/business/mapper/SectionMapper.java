package bstorm.akim.correctionExo3.business.mapper;

import bstorm.akim.correctionExo3.business.dto.SectionDTO;
import bstorm.akim.correctionExo3.business.dto.SmolStudentDTO;
import bstorm.akim.correctionExo3.business.dto.StudentDTO;
import bstorm.akim.correctionExo3.data_access.entities.Section;
import bstorm.akim.correctionExo3.data_access.entities.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.stream.Collectors;

@Component
public class SectionMapper implements Mapper<SectionDTO, Section> {

    @Autowired
    private Mapper<SmolStudentDTO, Student> mapper;

    // ATTENTION, SI DEPENDENCES CIRCULAIRES, DECLARER LA DEPENDENCE AVEC @AUTOWIRED
//    public SectionMapper(Mapper<StudentDTO, Student> mapper) {
//        this.mapper = mapper;
//    }

    @Override
    public SectionDTO toDTO(Section section) {
        // on evite les nullPointer
        if(section == null)
            return null;

        return new SectionDTO(
                section.getId(),
                section.getName(),
                section.getDelegateId(),
                section.getStudents() == null ? null :
                section.getStudents().stream()
                        .map(mapper::toDTO)
                        .collect(Collectors.toList())
        );
    }

    @Override
    public Section toEntity(SectionDTO sectionDTO) {
        // on evite les nullPointer
        if(sectionDTO == null)
            return null;

        Section section = new Section();

        section.setId(sectionDTO.getId());
        section.setName(sectionDTO.getName());
        section.setDelegateId(sectionDTO.getDelegateId());
        if( sectionDTO.getStudents() != null )
            section.setStudents(sectionDTO.getStudents().stream()
                        .map(mapper::toEntity) // TODO : aide du mapper de student
                        .collect(Collectors.toList()));

        return section;
    }
}
