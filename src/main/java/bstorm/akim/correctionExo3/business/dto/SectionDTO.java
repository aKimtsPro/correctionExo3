package bstorm.akim.correctionExo3.business.dto;

import lombok.*;

import java.util.List;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class SectionDTO {

    private int id;
    private String name;
    private int delegateId;

    private List<SmolStudentDTO> students;
}
