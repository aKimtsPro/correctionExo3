package bstorm.akim.correctionExo3.presentation;

import bstorm.akim.correctionExo3.business.dto.SectionDTO;
import bstorm.akim.correctionExo3.business.service.CrudService;
import bstorm.akim.correctionExo3.exception.ElementAlreadyExistsException;
import bstorm.akim.correctionExo3.exception.ElementNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.InputMismatchException;
import java.util.Scanner;

public abstract class MenuSecondaireImpl<DTO> implements Menu{

    @Autowired
    protected CrudService<DTO, Integer> service;
    @Autowired
    protected Scanner scanner;

    private void afficherMenu(){
        System.out.println("MENU SECTION:" +
                "\n\t1 - ajouter;" +
                "\n\t2 - lire un;" +
                "\n\t3 - lire tous;" +
                "\n\t4 - update;" +
                "\n\t5 - delete;" +
                "\n\t6 - quitter");
    }

    private int getChoix(){
        System.out.println("Quel est votre choix?");
        try {
            return scanner.nextInt();
        } catch (InputMismatchException e){
            System.out.println("choix invalide.");
        }
        return -1;
    }
    private void mapChoix(int choix){
        switch (choix){
            case 1:
                ajouter();
                break;
            case 2:
                lireUn();
                break;
            case 3:
                lireTout();
                break;
            case 4:
                modifier();
                break;
            case 5:
                supprimer();
                break;
            case 6:
                quitter();
                break;
            default:
                System.out.println("Choix invalide veuillez recommencer");
        }
    }


    protected abstract void ajouter();
    private void lireUn(){
        System.out.println("Quel est l'id de l'élément que vous souhaitez voir.");
        try {
            System.out.println( service.readOne(scanner.nextInt()) );
        } catch (ElementNotFoundException e) {
            System.out.println("L'élément n'existe pas veuillez réessayer");
        }
    }
    private void lireTout(){
        service.readAll().forEach(System.out::println);
    }
    protected abstract void modifier();
    private void supprimer(){
        System.out.println("Veuillez préciser l'id de l'élément à supprimer:");
        try {
            service.delete(scanner.nextInt());
        } catch (ElementNotFoundException e) {
            System.out.println("L'élément n'existe pas veuillez réessayer.");
        }
    }
    private void quitter(){
        System.out.println("\nretour au menu principal ... \n");
    }

    @Override
    public void start() {

        int choix;
        do {
            afficherMenu();
            choix = getChoix();
            mapChoix(choix);
        }while (choix != 6);

    }

}
