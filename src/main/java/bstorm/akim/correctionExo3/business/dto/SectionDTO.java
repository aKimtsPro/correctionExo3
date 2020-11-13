package bstorm.akim.correctionExo3.business.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class SectionDTO {

    private int id;
    private String name;
    private int delegateId;

    private List<StudentDTO> students;
}
