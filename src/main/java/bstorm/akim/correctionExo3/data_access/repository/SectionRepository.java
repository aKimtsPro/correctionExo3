package bstorm.akim.correctionExo3.data_access.repository;

import bstorm.akim.correctionExo3.data_access.entities.Section;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SectionRepository extends JpaRepository<Section, Integer> {
}
