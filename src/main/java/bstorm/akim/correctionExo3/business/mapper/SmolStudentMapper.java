package bstorm.akim.correctionExo3.business.mapper;

import bstorm.akim.correctionExo3.business.dto.SectionStudentDTO;
import bstorm.akim.correctionExo3.data_access.entities.Student;
import bstorm.akim.correctionExo3.data_access.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SmolStudentMapper implements Mapper<SectionStudentDTO, Student> {

    @Autowired
    private StudentRepository repository;

    @Override
    public SectionStudentDTO toDTO(Student student) {
        // on evite les nullPointer
        if(student == null)
            return null;

        return new SectionStudentDTO(
                student.getId(),
                student.getFirstname(),
                student.getLastname()
        );
    }

    @Override
    public Student toEntity(SectionStudentDTO smolStudentDTO) {
        if(smolStudentDTO == null)
            return null;

        return repository.getOne(smolStudentDTO.getId());
    }
}
