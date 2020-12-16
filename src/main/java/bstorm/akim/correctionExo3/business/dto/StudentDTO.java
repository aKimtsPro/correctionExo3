package bstorm.akim.correctionExo3.business.dto;

import lombok.*;
import java.time.LocalDateTime;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class StudentDTO implements IdentifiedDTO<Integer> {

    private Integer id;
    private String firstname;
    private String lastname;
    private LocalDateTime birthdate;
    private String login;
    private StudentSectionDTO section;
    private int yearResult;
    private String courseId;

}
