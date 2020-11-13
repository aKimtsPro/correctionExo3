package bstorm.akim.correctionExo3.data_access.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

@Entity
@Getter @Setter
@NoArgsConstructor
public class Section implements Serializable {

    @Id
    @Column(name = "section_id")
    private int id;

    @Column(name = "section_name")
    private String name;

    @Column(name = "delegate_id")
    private int delegateId;

    @OneToMany(mappedBy = "section"/*, fetch = FetchType.EAGER*/)
    private Collection<Student> students;

}
