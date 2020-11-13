package bstorm.akim.correctionExo3.business.dto;

import lombok.*;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
// DTO sans info sur la section pour
// eviter la redondance d'info dans le StudentDTO
// Ainsi que les stackOverFlow
public class SmolSectionDTO {
    private int id;
    private String name;
    private int delegateId;
}
