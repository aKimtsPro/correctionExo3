package bstorm.akim.correctionExo3.data_access.repository;

import bstorm.akim.correctionExo3.data_access.entities.Section;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

//@NoRepositoryBean // A mettre si on souhaite que spring n'instancie pas
                    // de bean sur ce repo
public interface SectionRepository extends JpaRepository<Section, Integer> {
}
