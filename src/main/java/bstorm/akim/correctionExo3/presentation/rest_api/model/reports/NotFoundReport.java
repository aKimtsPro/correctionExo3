package bstorm.akim.correctionExo3.presentation.rest_api.model.reports;

public class NotFoundReport extends ElementReport{

    public NotFoundReport(Object id, String elementType) {
        super(id, elementType, "Il n'existe pas l'élément ayant cet id");
    }
}
