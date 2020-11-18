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

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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


    // top 3 des stud d'une section
    public List<StudentDTO> top3FromSection(int sectionId){

        return repository.findAll().stream()
                .filter((student) -> student.getSection().getId() == sectionId)
                .sorted((s1,s2) -> s2.getYearResult() - s1.getYearResult())
                .limit(3)
                .map(mapper::toDTO)
                .collect(Collectors.toList());

    }
    // moyenne des rslt pour une section
    public double averageForSection(int sectionId){

        return repository.findAll().stream()
                .filter((student) -> student.getSection().getId() == sectionId)
                .mapToInt(Student::getYearResult) // IntStream
                .average()
                .orElse( 0 );

    }
    // etudiant le plus agé
    public Optional<StudentDTO> getOldest(){

        return repository.findAll().stream()
                .min( (s1, s2) -> s1.getBirthdate().compareTo(s2.getBirthdate()))
                .map( mapper::toDTO );

    }
    //
    public Character[] distinctLettersFromNames(){

        return repository.findAll().stream()
                .map(Student::getLastname)
                .flatMap(lastname -> {
                    ArrayList<Character> list = new ArrayList<>();
                    for (int i = 0; i < lastname.length(); i++) {
                        list.add(lastname.charAt(i));
                    }
                    return list.stream();
                })
                .map(Character::toLowerCase)
                .filter(character -> character >= 'a' && character <= 'z')
                .distinct()
                .toArray(Character[]::new);

    }
    //
    public Optional<String> findAnyNamesWithResult(int result){

        return repository.findAll().stream()
                .filter((student) -> student.getYearResult() == result )
                .map(student -> student.getFirstname() + " " + student.getLastname() )
                .findAny();

    }
    //
    public boolean successFromSection(int sectionId){

        return repository.findAll().stream()
                .filter(student -> student.getSection().getId() == sectionId)
                .allMatch( student -> student.getYearResult() >= 10 );

    }
    //
    public void addPointsToStartingWithLetter(int points, char letter){

        repository.findAll().stream()
                .filter(student -> Character.toLowerCase(student.getLastname().charAt(0)) == Character.toLowerCase(letter))
                .forEach(student -> {
                    student.setYearResult( student.getYearResult() + points );
                    repository.save(student);
                });

    }
    //
    public long countSuccess(){

        return repository.findAll().stream()
                .filter(student -> student.getYearResult() >= 10)
                .count();
    }
}
