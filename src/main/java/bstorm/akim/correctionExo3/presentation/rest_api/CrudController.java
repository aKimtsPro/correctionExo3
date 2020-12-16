package bstorm.akim.correctionExo3.presentation.rest_api;

import bstorm.akim.correctionExo3.business.dto.IdentifiedDTO;
import bstorm.akim.correctionExo3.presentation.rest_api.model.containers.ElementsContainer;
import bstorm.akim.correctionExo3.exception.ElementAlreadyExistsException;
import bstorm.akim.correctionExo3.exception.ElementNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

public interface CrudController<DTO extends IdentifiedDTO<ID>, ID> {

    // Create
    void create(@RequestBody DTO dto) throws ElementAlreadyExistsException;

    // Read
    ResponseEntity<DTO> getOne(@PathVariable ID id) throws ElementNotFoundException;
    ResponseEntity<ElementsContainer<DTO>> getAll();

    // Update
    ResponseEntity<String> update(@RequestBody DTO dto) throws ElementNotFoundException;

    // Delete
    ResponseEntity<DTO> delete(@PathVariable ID id) throws ElementNotFoundException;

}
