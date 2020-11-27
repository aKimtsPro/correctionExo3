package bstorm.akim.correctionExo3.business.dto.container;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter @Getter
@AllArgsConstructor
public class ElementsContainer<DTO> {

    private final List<DTO> list;
    private final int count;

}
