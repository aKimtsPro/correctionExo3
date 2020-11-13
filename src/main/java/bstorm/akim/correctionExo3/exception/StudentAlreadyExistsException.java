package bstorm.akim.correctionExo3.exception;

import bstorm.akim.correctionExo3.business.dto.StudentDTO;

public class StudentAlreadyExistsException extends ElementAlreadyExistsException{
    public StudentAlreadyExistsException(int id) {
        super(id, StudentDTO.class);
    }
}
