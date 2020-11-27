package bstorm.akim.correctionExo3.business.dto.reports;

import lombok.Getter;

@Getter
public class AlreadyExistsReport extends ElementReport {

    public AlreadyExistsReport(Object id, String elementType) {
        super(id, elementType, "Un élément avec l'id mentionné existe déjà");
    }
}
