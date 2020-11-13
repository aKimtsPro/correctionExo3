package bstorm.akim.correctionExo3.exception;

import bstorm.akim.correctionExo3.business.dto.StudentDTO;

public class StudentNotFoundException extends ElementNotFoundException {

    public StudentNotFoundException(int id) {
        super(StudentDTO.class, id);
    }
}
