package bstorm.akim.correctionExo3.presentation.console;

import bstorm.akim.correctionExo3.business.dto.StudentDTO;
import org.springframework.stereotype.Component;

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
