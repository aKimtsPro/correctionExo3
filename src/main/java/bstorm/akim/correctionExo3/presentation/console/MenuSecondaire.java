package bstorm.akim.correctionExo3.presentation.console;

import bstorm.akim.correctionExo3.business.dto.IdentifiedDTO;
import bstorm.akim.correctionExo3.business.service.CrudService;
import bstorm.akim.correctionExo3.exception.ElementAlreadyExistsException;
import bstorm.akim.correctionExo3.exception.ElementNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.InputMismatchException;
import java.util.Scanner;

public abstract class MenuSecondaire<DTO extends IdentifiedDTO<ID>,ID> implements CrudMenu<DTO,ID> {

    @Autowired
    protected CrudService<DTO, ID> service;
    @Autowired
    protected Scanner scanner;

    protected abstract DTO promptData();
    protected abstract ID promptId();

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

    private void ajouter(){
        try {
            service.create( promptData() );
        } catch (ElementAlreadyExistsException e) {
            System.out.println("L'element existe déjà, veuillez réessayer.");
        } catch (InputMismatchException ime){
            System.out.println("Données invalides. Veuillez recommencer!");
        }
    }
    private void lireUn(){
        System.out.println("Quel est l'id de l'élément que vous souhaitez voir.");
        try {
            System.out.println( service.readOne(promptId()) );
        } catch (ElementNotFoundException e) {
            System.out.println("L'élément n'existe pas veuillez réessayer");
        }
    }
    private void lireTout(){
        service.readAll().forEach(System.out::println);
    }
    private void modifier(){
        try {
            service.update( promptData() );
        } catch (ElementNotFoundException e) {
            System.out.println("L'element existe déjà, veuillez réessayer.");
        }
    }
    private void supprimer(){
        System.out.println("Veuillez préciser l'id de l'élément à supprimer:");
        try {
            service.delete(promptId());
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
