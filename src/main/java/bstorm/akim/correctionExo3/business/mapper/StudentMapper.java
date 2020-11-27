package bstorm.akim.correctionExo3.business.mapper;

import bstorm.akim.correctionExo3.business.dto.StudentSectionDTO;
import bstorm.akim.correctionExo3.business.dto.StudentDTO;
import bstorm.akim.correctionExo3.data_access.entities.Section;
import bstorm.akim.correctionExo3.data_access.entities.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class StudentMapper implements Mapper<StudentDTO, Student> {

    @Autowired
    private Mapper<StudentSectionDTO, Section> mapper;

    // ATTENTION, SI DEPENDENCES CIRCULAIRES, DECLARER LA DEPENDENCE AVEC @AUTOWIRED
//    public StudentMapper(Mapper<SectionDTO, Section> mapper) {
//        this.mapper = mapper;
//    }

    @Override
    public StudentDTO toDTO(Student student) {
        // on evite les nullPointer
        if(student == null)
            return null;

        return new StudentDTO(
                student.getId(),
                student.getFirstname(),
                student.getLastname(),
                student.getBirthdate(),
                student.getLogin(),
                mapper.toDTO(student.getSection()),
                student.getYearResult(),
                student.getCourseId()
        );
    }

    @Override
    public Student toEntity(StudentDTO studentDTO) {
        // on evite les nullPointer
        if(studentDTO == null)
            return null;

        Student entity = new Student();
        entity.setId(studentDTO.getId());
        entity.setFirstname(studentDTO.getFirstname());
        entity.setLastname(studentDTO.getLastname());
        entity.setLogin(studentDTO.getLogin());
        entity.setCourseId(studentDTO.getCourseId());
        entity.setYearResult(studentDTO.getYearResult());
        entity.setBirthdate(studentDTO.getBirthdate());

        entity.setSection( mapper.toEntity(studentDTO.getSection()));
        return entity;
    }
}
