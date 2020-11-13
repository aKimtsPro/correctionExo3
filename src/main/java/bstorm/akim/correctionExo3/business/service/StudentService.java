package bstorm.akim.correctionExo3.business.service;

import bstorm.akim.correctionExo3.business.dto.StudentDTO;
import bstorm.akim.correctionExo3.business.mapper.Mapper;
import bstorm.akim.correctionExo3.data_access.entities.Student;
import bstorm.akim.correctionExo3.data_access.repository.StudentRepository;
import bstorm.akim.correctionExo3.exception.ElementNotFoundException;
import bstorm.akim.correctionExo3.exception.StudentAlreadyExistsException;
import bstorm.akim.correctionExo3.exception.StudentNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentService implements CrudService<StudentDTO, Integer>{

    @Autowired
    private Mapper<StudentDTO, Student> mapper;
    @Autowired
    private StudentRepository repository;


    @Override
    public void create(StudentDTO toCreate) throws StudentAlreadyExistsException {
        if(repository.existsById(toCreate.getId()))
            throw new StudentAlreadyExistsException(toCreate.getId());

        repository.save(mapper.toEntity(toCreate));
    }

    @Override
    public StudentDTO readOne(Integer id) throws ElementNotFoundException {
        Student entity = repository.findById(id)
                .orElseThrow(()-> new StudentNotFoundException(id));

        return mapper.toDTO(entity);
    }

    @Override
    public List<StudentDTO> readAll() {
        return repository.findAll().stream()
                .map(mapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public void update(StudentDTO toUpdate) throws ElementNotFoundException {

        if( !repository.existsById(toUpdate.getId()))
            throw new StudentNotFoundException(toUpdate.getId());

        repository.save( mapper.toEntity(toUpdate) );
    }

    @Override
    public void delete(Integer toDelete) throws ElementNotFoundException {

        if( !repository.existsById(toDelete))
            throw new StudentNotFoundException(toDelete);

        repository.deleteById(toDelete);
    }
}
