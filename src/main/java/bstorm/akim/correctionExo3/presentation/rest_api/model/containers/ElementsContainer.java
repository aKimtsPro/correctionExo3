package bstorm.akim.correctionExo3.presentation.rest_api.model.containers;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter @Getter
public class ElementsContainer<DTO> {

    private final int count;
    private final List<DTO> list;

    public ElementsContainer(List<DTO> list) {
        this.list = list;
        this.count = list.size();
    }
}
