package bstorm.akim.correctionExo3.presentation.console;

import bstorm.akim.correctionExo3.business.dto.StudentDTO;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("console")
public class MenuSecondaireStudentMock extends MenuSecondaire<StudentDTO, Integer> {


    @Override
    protected Integer promptId() {
        System.out.print("Veuillez entrer un ID:");
        return scanner.nextInt();
    }
    @Override
    protected StudentDTO promptData() {
        return new StudentDTO();
    }

}
