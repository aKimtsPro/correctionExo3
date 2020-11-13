package bstorm.akim.correctionExo3.presentation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.InputMismatchException;
import java.util.Scanner;

@Component
public class MenuPrincipalImpl implements MenuPrincipal {

    @Autowired
    private Scanner scanner;
    @Autowired
    private MenuSecondaireSection menuSection;
    @Autowired
    private MenuSecondaireStudent menuStudent;

    private void afficherMenu(){
        System.out.println("MENU PRINCIPAL:\n" +
                "\nQuel set d'infos voulez-vous modifier?\n" +
                "\t1 - etudiants\n" +
                "\t2 - sections\n" +
                "\t3 - quitter");
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
                menuStudent.start();
                break;
            case 2:
                menuSection.start();
                break;
            case 3:
                System.out.println("Merci d'avoir utilisé l'application! a plus");
                break;
            default:
                System.out.println("veuillez réessayer");
        }
    }


    @Override
    public void start() {
        int choix;
        do {
            afficherMenu();
            choix = getChoix();
            mapChoix(choix);
        }while (choix != 3);

    }

    @Override
    public void afterPropertiesSet() throws Exception {
        start();
    }
}
