package bstorm.akim.correctionExo3.business.dto.container;

import bstorm.akim.correctionExo3.business.dto.SectionDTO;
import lombok.Getter;

import java.util.List;

@Getter
public class SectionsContainer extends ElementsContainer<SectionDTO> {

    public SectionsContainer(List<SectionDTO> list, int count) {
        super(list, count);
    }
}
