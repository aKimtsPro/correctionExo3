package bstorm.akim.correctionExo3.business.dto;

import lombok.*;

import java.util.List;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class SectionDTO implements IdentifiedDTO<Integer>{

    private Integer id; // pas auto_increment
    private String name;
    private int delegateId;

    private List<SectionStudentDTO> students;
}
