package bstorm.akim.correctionExo3.data_access.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;
import java.time.LocalDateTime;

@Entity
@Getter @Setter
@NoArgsConstructor
public class Student {

    @Id
    @Column(name = "student_id")
    private int id;

    @Column(name = "first_name")
    private String firstname;

    @Column(name = "last_name")
    private String lastname;

    @Column(name = "birth_date")
    private LocalDateTime birthdate;

    @Column
    private String login;

    @ManyToOne
    @JoinColumn(name = "section_id")
    private Section section;

    @Column(name = "year_result")
    private int yearResult;

    @Column(name = "course_id")
    private String courseId;

}
