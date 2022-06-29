package com.portofolio.tryapi.entity;

import lombok.*;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "students")
@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder

public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @GenericGenerator(name = "student_id", strategy = "uuid2")
    @Column(nullable = false, unique = true)
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private boolean isDeleted = Boolean.FALSE;

}
