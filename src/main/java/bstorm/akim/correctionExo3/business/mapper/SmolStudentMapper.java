package bstorm.akim.correctionExo3.business.mapper;

import bstorm.akim.correctionExo3.business.dto.SectionStudentDTO;
import bstorm.akim.correctionExo3.data_access.entities.Student;
import org.springframework.stereotype.Component;

@Component
public class SmolStudentMapper implements Mapper<SectionStudentDTO, Student> {
    @Override
    public SectionStudentDTO toDTO(Student student) {
        // on evite les nullPointer
        if(student == null)
            return null;

        return new SectionStudentDTO(
                student.getId(),
                student.getFirstname(),
                student.getLastname(),
                student.getBirthdate(),
                student.getLogin(),
                student.getYearResult(),
                student.getCourseId()
        );
    }

    @Override
    public Student toEntity(SectionStudentDTO smolStudentDTO) {
        if(smolStudentDTO == null)
            return null;

        Student entity = new Student();
        entity.setId(smolStudentDTO.getId());
        entity.setFirstname(smolStudentDTO.getFirstname());
        entity.setLastname(smolStudentDTO.getLastname());
        entity.setLogin(smolStudentDTO.getLogin());
        entity.setCourseId(smolStudentDTO.getCourseId());
        entity.setYearResult(smolStudentDTO.getYearResult());
        entity.setBirthdate(smolStudentDTO.getBirthdate());

        return entity;
    }
}
