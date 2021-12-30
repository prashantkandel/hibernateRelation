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
@Table(name = "tbl_student")
public class Student {

    @Id
    @SequenceGenerator(name = "student_seq",sequenceName = "student_seq",initialValue = 1,allocationSize = 1)
    @GeneratedValue(generator = "student_seq_gen",strategy = GenerationType.SEQUENCE)
    private Integer id;

    @Column(name = "student_name")
    private String studentName;

    @Column(name = "roll_number")
    private String rollNumber;

    @Column(name = "phone_number")
    private String phoneNumber;

    @ManyToMany(mappedBy = "students")
    private List<Subject> subjects;

}