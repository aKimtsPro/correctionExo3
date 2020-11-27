package bstorm.akim.correctionExo3.business.dto.container;

import bstorm.akim.correctionExo3.business.dto.StudentDTO;

import java.util.List;

public class StudentsContainer extends ElementsContainer<StudentDTO> {
    public StudentsContainer(List<StudentDTO> list, int count) {
        super(list, count);
    }
}
