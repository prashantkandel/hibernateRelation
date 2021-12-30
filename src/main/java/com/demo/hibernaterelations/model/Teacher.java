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
@Table(name = "tbl_teacher")
public class Teacher {

    @Id
    @SequenceGenerator(name = "teacher_seq",sequenceName = "teacher_seq",initialValue = 1,allocationSize = 1)
    @GeneratedValue(generator = "teacher_seq_gen",strategy = GenerationType.SEQUENCE)
    private Integer id;

    @Column(name = "teacher_name")
    private String teacherName;

    @Column(name = "teacher_email_id")
    private String teacherEmailId;

    @Column(name = "teacher_address")
    private String teacherAddress;

    @OneToMany(mappedBy = "teacher")
    private List<Subject> subjects;

}
