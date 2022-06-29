package com.portofolio.tryapi.repository;

import com.portofolio.tryapi.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;


public interface StudentsRepo extends JpaRepository<Student, Long> {

}



