package bstorm.akim.correctionExo3.exception;

import bstorm.akim.correctionExo3.business.dto.SectionDTO;

public class SectionAlreadyExistsException extends ElementAlreadyExistsException{
    public SectionAlreadyExistsException(int id) {
        super( id, SectionDTO.class );
    }
}
