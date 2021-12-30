package com.demo.hibernaterelations.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "tbl_subject_material")
@AllArgsConstructor
@NoArgsConstructor
public class SubjectMaterial {

    @Id
    @SequenceGenerator(name = "subject_material_seq",sequenceName = "subject_material_seq",initialValue = 1,allocationSize = 1)
    @GeneratedValue(generator = "subject_material_seq_gen",strategy = GenerationType.SEQUENCE)
    private Integer id;

    private String url;

    @OneToOne(optional = false)
    @JoinColumn(name = "subject_id",referencedColumnName = "id")
    private Subject subject;
}
