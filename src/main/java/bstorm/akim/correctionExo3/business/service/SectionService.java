package bstorm.akim.correctionExo3.business.service;

import bstorm.akim.correctionExo3.business.dto.SectionDTO;
import bstorm.akim.correctionExo3.business.mapper.Mapper;
import bstorm.akim.correctionExo3.data_access.entities.Section;
import bstorm.akim.correctionExo3.data_access.repository.SectionRepository;
import bstorm.akim.correctionExo3.exception.ElementNotFoundException;
import bstorm.akim.correctionExo3.exception.SectionAlreadyExistsException;
import bstorm.akim.correctionExo3.exception.SectionNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SectionService implements CrudService<SectionDTO, Integer>{

    @Autowired
    private Mapper<SectionDTO, Section> mapper;
    @Autowired
    private SectionRepository repository;

    @Override
    public void create(SectionDTO toCreate) throws SectionAlreadyExistsException {
        if(repository.existsById(toCreate.getId()))
            throw new SectionAlreadyExistsException(toCreate.getId());

        repository.save( mapper.toEntity(toCreate) );
    }

    @Override
    @Transactional
    public SectionDTO readOne(Integer id) throws ElementNotFoundException {
        Section entity = repository.findById(id)
                .orElseThrow(() -> new SectionNotFoundException(id));

        return mapper.toDTO(entity);
    }

    @Override
    @Transactional
    public List<SectionDTO> readAll() {
        return repository.findAll().stream()
                .map(mapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public void update(SectionDTO toUpdate) throws ElementNotFoundException {

        if( !repository.existsById( toUpdate.getId() ))
            throw new SectionNotFoundException(toUpdate.getId());

        repository.save( mapper.toEntity(toUpdate) );

    }

    @Override
    public void delete(Integer toDelete) throws ElementNotFoundException {

        if( !repository.existsById(toDelete))
            throw new SectionNotFoundException(toDelete);

        repository.deleteById(toDelete);

    }
}
