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
public class SectionStudentDTO implements IdentifiedDTO<Integer> {
    private Integer id;
    private String firstname;
    private String lastname;
}
