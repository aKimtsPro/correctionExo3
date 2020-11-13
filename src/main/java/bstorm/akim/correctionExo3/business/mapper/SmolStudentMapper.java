package bstorm.akim.correctionExo3.business.mapper;

import bstorm.akim.correctionExo3.business.dto.SmolStudentDTO;
import bstorm.akim.correctionExo3.business.dto.StudentDTO;
import bstorm.akim.correctionExo3.data_access.entities.Student;
import org.springframework.stereotype.Component;

@Component
public class SmolStudentMapper implements Mapper<SmolStudentDTO, Student> {
    @Override
    public SmolStudentDTO toDTO(Student student) {
        // on evite les nullPointer
        if(student == null)
            return null;

        return new SmolStudentDTO(
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
    public Student toEntity(SmolStudentDTO smolStudentDTO) {
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
