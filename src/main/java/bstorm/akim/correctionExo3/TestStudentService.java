package bstorm.akim.correctionExo3;

import bstorm.akim.correctionExo3.business.dto.StudentDTO;
import bstorm.akim.correctionExo3.business.service.StudentService;
import bstorm.akim.correctionExo3.exception.ElementNotFoundException;
import bstorm.akim.correctionExo3.exception.StudentAlreadyExistsException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.time.LocalDateTime;

@SpringBootApplication
public class TestStudentService {

    public static void main(String[] args){
        ApplicationContext ctx = SpringApplication.run(TestStudentService.class, args );
        StudentService service = ctx.getBean(StudentService.class);

        StudentDTO dto = new StudentDTO(
                1000,
                "lucas",
                "dubosquet",
                LocalDateTime.now(),
                "ldubosquet",
                null,
                20,
                "EG2222"
        );

        // Test insert - V

//        try {
//            service.create(dto);
//        } catch (StudentAlreadyExistsException e) {
//            System.out.println(e.getMessage());
//        }

        // Test readOne - V

//        try{
//            System.out.println(service.readOne(dto.getId()+1));
//        }catch (ElementNotFoundException e){
//            System.out.println(e.getMessage());
//        }

        // Test readAll - V

//        service.readAll().forEach(System.out::println);

        // Test update - V

//        try {
//            service.update(dto);
//        } catch (ElementNotFoundException e) {
//            System.out.println(e.getMessage());
//        }

        // test delete - V

//        try {
//            service.delete(dto.getId());
//        } catch (ElementNotFoundException e) {
//            System.out.println(e.getMessage());
//        }

    }
}
