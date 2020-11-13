package bstorm.akim.correctionExo3.presentation;

import bstorm.akim.correctionExo3.business.dto.SectionDTO;
import bstorm.akim.correctionExo3.business.service.CrudService;
import bstorm.akim.correctionExo3.exception.ElementAlreadyExistsException;
import bstorm.akim.correctionExo3.exception.ElementNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.InputMismatchException;
import java.util.Scanner;

@Component
public class MenuSecondaireSection extends MenuSecondaireImpl<SectionDTO> {

    @Override
    protected void ajouter(){

        System.out.println("Veuillez entrer la section à ajouter:");
        System.out.println("- ID -");
        int id = scanner.nextInt();
        System.out.println("- NAME -");
        String name = scanner.next();
        System.out.println("- Delegate id -");
        int delegateId = scanner.nextInt();

        try {
            service.create(new SectionDTO(
                    id,
                    name,
                    delegateId,
                    null
            ));
        } catch (ElementAlreadyExistsException e) {
            System.out.println("L'element existe déjà, veuillez réessayer.");
        }

    }
    @Override
    protected void modifier(){
        System.out.println("Veuillez entrer la section à modifier:");
        System.out.println("- ID -");
        int id = scanner.nextInt();
        System.out.println("Veuillez entrer les nouvelles infos de cet element");
        System.out.println("- NAME -");
        String name = scanner.next();
        System.out.println("- Delegate id -");
        int delegateId = scanner.nextInt();

        try {
            service.update(new SectionDTO(
                    id,
                    name,
                    delegateId,
                    null
            ));
        } catch (ElementNotFoundException e) {
            System.out.println("L'element existe déjà, veuillez réessayer.");
        }
    }

}
