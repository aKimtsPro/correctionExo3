package bstorm.akim.correctionExo3;

import bstorm.akim.correctionExo3.business.mapper.SectionMapper;
import bstorm.akim.correctionExo3.data_access.entities.Section;
import bstorm.akim.correctionExo3.data_access.entities.Student;
import bstorm.akim.correctionExo3.data_access.repository.StudentRepository;
import javafx.application.Application;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.sql.Date;
import java.time.LocalDateTime;
import java.util.Arrays;

@SpringBootApplication
public class CorrectionExo3Application {

	public static void main(String[] args) {

		ApplicationContext ctx = SpringApplication.run(CorrectionExo3Application.class, args);
		SectionMapper sr = ctx.getBean(SectionMapper.class);

		Section s = new Section();
		s.setName("ma section");

		Student stud1 = new Student();
		stud1.setFirstname("ola");
		stud1.setLastname("alo");
		stud1.setBirthdate(LocalDateTime.MIN);

		Student stud2 = new Student();
		stud2.setFirstname("ola");
		stud2.setLastname("alo");
		stud2.setBirthdate(LocalDateTime.MIN);

		s.setStudents(Arrays.asList(stud1, stud2));

		System.out.println( sr.toDTO(s).getName() );

	}

}
