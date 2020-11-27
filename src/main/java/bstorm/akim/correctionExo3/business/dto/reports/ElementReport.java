package bstorm.akim.correctionExo3.business.dto.reports;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public abstract class ElementReport {

    private final Object id;
    private final String elementType;
    private final String message;

}
