package bstorm.akim.correctionExo3.business.dto;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
// DTO sans info sur la section pour
// eviter la redondance d'info dans le SectionDTO
// Ainsi que les stackOverFlow
public class SmolStudentDTO {
    private int id;
    private String firstname;
    private String lastname;
    private LocalDateTime birthdate;
    private String login;
    private int yearResult;
    private String courseId;
}
