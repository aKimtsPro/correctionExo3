package bstorm.akim.correctionExo3;

import bstorm.akim.correctionExo3.business.dto.SectionDTO;
import bstorm.akim.correctionExo3.business.dto.StudentDTO;
import bstorm.akim.correctionExo3.business.mapper.SectionMapper;
import bstorm.akim.correctionExo3.business.mapper.StudentMapper;
import bstorm.akim.correctionExo3.data_access.entities.Section;
import bstorm.akim.correctionExo3.data_access.entities.Student;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.time.LocalDateTime;
import java.util.Arrays;

@SpringBootApplication
public class TestMappers {

    public static void main(String[] args) {

        ApplicationContext ctx = SpringApplication.run(TestSectionService.class, args);

        SectionMapper s_mapper = ctx.getBean(SectionMapper.class);
        StudentMapper stud_mapper = ctx.getBean(StudentMapper.class);

        Section s = new Section();
        s.setName("ma section");

        Student stud1 = new Student();
        stud1.setFirstname("ola");
        stud1.setLastname("alo");
        stud1.setBirthdate(LocalDateTime.MIN);
        stud1.setSection(s); // TODO : regler la stackOverflow

        Student stud2 = new Student();
        stud2.setFirstname("ola");
        stud2.setLastname("alo");
        stud2.setBirthdate(LocalDateTime.MIN);
        stud2.setSection(s); // TODO : regler stackOverflow

        s.setStudents(Arrays.asList(stud1, stud2));

        // Test sectionMapper

        SectionDTO dto = s_mapper.toDTO(s);
        System.out.println("----          Section:       ----");
        System.out.println(dto);
        System.out.println("---- Etudiants de la section: ----");
        dto.getStudents().forEach(System.out::println);

        System.out.println("\n\n");

        // Test studentMapper

        StudentDTO studDTO = stud_mapper.toDTO(stud1);
        System.out.println("---- Etudiant stud1 : ----");
        System.out.println( studDTO );
        System.out.println("---- section de stud1 : ----");
        System.out.println( studDTO.getSection() );
    }
}
