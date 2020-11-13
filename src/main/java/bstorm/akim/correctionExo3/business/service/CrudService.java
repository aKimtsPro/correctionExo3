package bstorm.akim.correctionExo3.business.service;

import bstorm.akim.correctionExo3.exception.ElementNotFoundException;

import javax.swing.text.Element;
import java.util.List;

public interface CrudService<DTO, ID> {

    // Create
    void create(DTO toCreate);

    // Read
    DTO readOne(ID id) throws ElementNotFoundException;
    List<DTO> readAll();

    // Update
    void update(DTO toUpdate) throws ElementNotFoundException;

    // Delete
    void delete(ID toDelete) throws ElementNotFoundException;

}
