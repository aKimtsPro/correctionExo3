package bstorm.akim.correctionExo3.presentation.rest_api.adviser;

import bstorm.akim.correctionExo3.presentation.rest_api.model.reports.AlreadyExistsReport;
import bstorm.akim.correctionExo3.presentation.rest_api.model.reports.NotFoundReport;
import bstorm.akim.correctionExo3.exception.ElementAlreadyExistsException;
import bstorm.akim.correctionExo3.exception.ElementNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ControllerAdviser {

    @ExceptionHandler(ElementAlreadyExistsException.class)
    public ResponseEntity<AlreadyExistsReport> elementAlreadyExistsHandler(ElementAlreadyExistsException ex )
    {
        AlreadyExistsReport report = new AlreadyExistsReport(ex.getId(), ex.getClazz().getSimpleName());
        return ResponseEntity.badRequest().body(report);
    }

    @ExceptionHandler(ElementNotFoundException.class)
    public ResponseEntity<NotFoundReport> elementNotFoundHandler(ElementNotFoundException ex )
    {
        NotFoundReport report = new NotFoundReport(ex.getId(), ex.getClazz().getSimpleName());
        return ResponseEntity.badRequest().body(report);
    }
}
