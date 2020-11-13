package bstorm.akim.correctionExo3.exception;

import bstorm.akim.correctionExo3.business.dto.SectionDTO;

public class SectionNotFoundException extends ElementNotFoundException {

    public SectionNotFoundException(int id) {
        super(SectionDTO.class, id);
    }
}
