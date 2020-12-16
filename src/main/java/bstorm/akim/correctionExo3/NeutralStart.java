package bstorm.akim.correctionExo3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class NeutralStart {

    public static void main(String[] args) {
        ApplicationContext ctx = SpringApplication.run(NeutralStart.class, args);
        System.out.println("launch finished");
    }
}
