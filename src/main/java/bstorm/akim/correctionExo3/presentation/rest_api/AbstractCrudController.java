package bstorm.akim.correctionExo3.presentation.rest_api;


import bstorm.akim.correctionExo3.business.dto.IdentifiedDTO;
import bstorm.akim.correctionExo3.presentation.rest_api.model.containers.ElementsContainer;
import bstorm.akim.correctionExo3.business.service.CrudService;
import bstorm.akim.correctionExo3.exception.ElementAlreadyExistsException;
import bstorm.akim.correctionExo3.exception.ElementNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public abstract class AbstractCrudController<DTO extends IdentifiedDTO<ID>, ID> implements CrudController<DTO, ID>{

    private final CrudService<DTO, ID> service;

    public AbstractCrudController(CrudService<DTO, ID> service) {
        this.service = service;
    }

    // CREATE - POST > http://localhost:8081/?
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody DTO dto) throws ElementAlreadyExistsException {
        service.create(dto);
    }

    // READ_ONE - GET > http://localhost:8081/?/{id}
    @GetMapping("/{id}")
    public ResponseEntity<DTO> getOne(@PathVariable ID id) throws ElementNotFoundException {
        return ResponseEntity.ok( service.readOne(id) );
    }

    // READ_ALL - GET > http://localhost:8081/?
    @GetMapping
    public ResponseEntity<ElementsContainer<DTO>> getAll(){
        List<DTO> list = service.readAll();
        return ResponseEntity.ok( new ElementsContainer<>(list, list.size()) );
    }

    // UPDATE - PUT > http://localhost:8081/?
    @PutMapping
    public ResponseEntity<String> update(@RequestBody DTO dto) throws ElementNotFoundException {
        service.update(dto);
        return ResponseEntity.ok("Un élément a été modifié" );
    }

    // DELETE - DELETE > http://localhost:8081/?/{id}
    @DeleteMapping("/{id}")
    public ResponseEntity<DTO> delete(@PathVariable ID id) throws ElementNotFoundException {
        DTO dto = service.readOne(id);
        service.delete(id);
        return ResponseEntity.ok(dto);
    }
}
