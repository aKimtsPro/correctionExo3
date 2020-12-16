package bstorm.akim.correctionExo3.presentation.console;

import bstorm.akim.correctionExo3.business.dto.SectionDTO;
import bstorm.akim.correctionExo3.exception.ElementAlreadyExistsException;
import bstorm.akim.correctionExo3.exception.ElementNotFoundException;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.InputMismatchException;

@Component
@Profile("console")
public class MenuSecondaireSection extends MenuSecondaire<SectionDTO, Integer> {

    @Override
    protected Integer promptId() {
        System.out.print("Veuillez entrer un ID:");
        return scanner.nextInt();
    }

    @Override
    protected SectionDTO promptData(){
        System.out.println("Veuillez entrer la section à ajouter:");
        System.out.println("- ID -");
        int id = scanner.nextInt();
        System.out.println("- NAME -");
        String name = scanner.next();
        System.out.println("- Delegate id -");
        int delegateId = scanner.nextInt();
        return new SectionDTO(
                id,
                name,
                delegateId,
                null
        );
    }

}
