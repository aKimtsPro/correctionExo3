package bstorm.akim.correctionExo3;

import bstorm.akim.correctionExo3.business.service.StudentService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.Arrays;

@SpringBootApplication
public class CorrectionExoStream {

    public static void main(String[] args) {
        ApplicationContext ctx = SpringApplication.run(CorrectionExoStream.class, args);

        StudentService service = ctx.getBean(StudentService.class);

        // service.top3FromSection(1110).forEach(System.out::println);
        // System.out.println(service.averageForSection(1110));
        // System.out.println( service.getOldest().orElseThrow() );
        // System.out.println(Arrays.toString(service.distinctLettersFromNames()));
        // System.out.println( service.findAnyNamesWithResult( 10 ));
        // System.out.println("success in 1120 : " + service.successFromSection(1120));
        // service.addPointsToStartingWithLetter(6, 'e'); // ajoute 6 à eastwood
        System.out.println("nombre de succes : " + service.countSuccess());
    }

}
