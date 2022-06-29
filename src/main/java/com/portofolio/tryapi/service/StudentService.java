package com.portofolio.tryapi.service;

import com.portofolio.tryapi.dtos.StudentRequest;
import com.portofolio.tryapi.dtos.StudentResponse;

import java.util.List;
import java.util.Optional;

public interface StudentService {
    List<StudentResponse> getAllStudent();
    StudentResponse saveStudent(StudentRequest studentRequest);
    Optional<StudentResponse> getStudentById(Long id);
    StudentResponse updateStudent(Long id, StudentRequest studentRequest);
    void deleteStudentById(Long id);

}
