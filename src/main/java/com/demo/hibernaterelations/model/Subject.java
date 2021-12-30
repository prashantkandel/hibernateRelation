package com.demo.hibernaterelations.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tbl_subject")
public class Subject {

    @Id
    @SequenceGenerator(name = "subject_seq",sequenceName = "subject_seq",initialValue = 1,allocationSize = 1)
    @GeneratedValue(generator = "subject_seq_gen",strategy = GenerationType.SEQUENCE)
    private Integer id;

    @Column(name = "subject_name")
    private String subjectName;

    @Column(name = "subject_author_name")
    private String subjectAuthorName;

    @ManyToOne
    @JoinColumn(name = "teacher_id",referencedColumnName = "id")
    private Teacher teacher;

    @OneToOne(mappedBy = "subject")
    private SubjectMaterial subjectMaterial;

    @ManyToMany
    @JoinTable(
            name = "jtbl_students_subjects",
            joinColumns = @JoinColumn(name = "subject_id",referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "student_id",referencedColumnName = "id")
    )
    private List<Student> students;

}
