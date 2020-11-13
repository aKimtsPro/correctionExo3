package bstorm.akim.correctionExo3.presentation;

import bstorm.akim.correctionExo3.business.dto.SectionDTO;
import bstorm.akim.correctionExo3.business.dto.StudentDTO;
import bstorm.akim.correctionExo3.business.service.CrudService;
import bstorm.akim.correctionExo3.data_access.entities.Student;
import bstorm.akim.correctionExo3.exception.ElementAlreadyExistsException;
import bstorm.akim.correctionExo3.exception.ElementNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.InputMismatchException;
import java.util.Scanner;

@Component
public class MenuSecondaireStudent extends MenuSecondaireImpl<StudentDTO>{


    @Override
    protected void ajouter() {
        System.out.println("a faire");
    }

    @Override
    protected void modifier() {
        System.out.println(" a faire");
    }

}
