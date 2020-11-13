package bstorm.akim.correctionExo3;

import bstorm.akim.correctionExo3.business.mapper.SectionMapper;
import bstorm.akim.correctionExo3.data_access.entities.Section;
import bstorm.akim.correctionExo3.data_access.entities.Student;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.time.LocalDateTime;
import java.util.Arrays;

@SpringBootApplication
public class CorrectionExo3Application {

	public static void main(String[] args) {

		ApplicationContext ctx = SpringApplication.run(CorrectionExo3Application.class, args);
		SectionMapper mapper = ctx.getBean(SectionMapper.class);

		Section s = new Section();
		s.setName("ma section");

		Student stud1 = new Student();
		stud1.setFirstname("ola");
		stud1.setLastname("alo");
		stud1.setBirthdate(LocalDateTime.MIN);
		stud1.setSection(s);

		Student stud2 = new Student();
		stud2.setFirstname("ola");
		stud2.setLastname("alo");
		stud2.setBirthdate(LocalDateTime.MIN);
		stud2.setSection(s);

		s.setStudents(Arrays.asList(stud1, stud2));

		mapper.toDTO(s).getStudents().forEach((stud) -> System.out.println(stud.getFirstname()));

	}

}
