package bstorm.akim.correctionExo3.business.dto;

import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class StudentDTO {

    private int id;
    private String firstname;
    private String lastname;
    private LocalDateTime birthdate;
    private String login;
    private SectionDTO section;
    private int yearResult;
    private String courseId;

}
