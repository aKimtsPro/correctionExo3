package bstorm.akim.correctionExo3.data_access.repository;

import bstorm.akim.correctionExo3.data_access.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Integer> {
}
