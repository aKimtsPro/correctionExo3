package bstorm.akim.correctionExo3;

import bstorm.akim.correctionExo3.presentation.MenuPrincipal;
import bstorm.akim.correctionExo3.presentation.MenuPrincipalImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class TestMenu {

    public static void main(String[] args) {
        ApplicationContext ctx = SpringApplication.run(TestMenu.class, args);
    }
}
