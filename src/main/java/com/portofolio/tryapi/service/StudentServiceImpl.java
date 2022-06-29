package com.portofolio.tryapi.service;

import com.portofolio.tryapi.dtos.StudentRequest;
import com.portofolio.tryapi.dtos.StudentResponse;
import com.portofolio.tryapi.entity.Student;
import com.portofolio.tryapi.repository.StudentsRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class StudentServiceImpl implements StudentService {

    private StudentsRepo studentsRepo;

    @Override
    public List<StudentResponse> getAllStudent() {
        List<Student> students = studentsRepo.findAll();
        List<StudentResponse> responsesFromStudents = new ArrayList<>();
        for (Student student : students) {
            StudentResponse response = StudentResponse.builder()
                    .id(student.getId())
                    .firstName(student.getFirstName())
                    .lastName(student.getLastName())
                    .email(student.getEmail())
                    .build();
            responsesFromStudents.add(response);
        }
        return responsesFromStudents;
    }

    @Override
    public StudentResponse saveStudent(StudentRequest studentRequest) {

        Student requestToStudent = Student.builder()
                .firstName(studentRequest.getFirstName())
                .lastName(studentRequest.getLastName())
                .email(studentRequest.getEmail())
                .isDeleted(true)
                .build();

        Student savedStudent = studentsRepo.save(requestToStudent);
        return StudentResponse.builder()
                .id(savedStudent.getId())
                .firstName(savedStudent.getFirstName())
                .lastName(savedStudent.getLastName())
                .email(savedStudent.getEmail())
                .build();
    }


    @Override
    public Optional<StudentResponse> getStudentById(Long id) {
        return studentsRepo.findById(id).map(student -> StudentResponse.builder()
                .id(student.getId())
                .firstName(student.getFirstName())
                .lastName(student.getLastName())
                .email(student.getEmail())
                .build());
    }

    @Override
    public StudentResponse updateStudent(Long id, StudentRequest studentRequest) {
        Optional<Student> findIdStudent = studentsRepo.findById(id);
        findIdStudent.get().setFirstName(studentRequest.getFirstName());
        findIdStudent.get().setLastName(studentRequest.getLastName());
        findIdStudent.get().setEmail(studentRequest.getEmail());

        Student savedStudent = studentsRepo.save(findIdStudent.get());
        return StudentResponse.builder()
                .id(savedStudent.getId())
                .firstName(savedStudent.getFirstName())
                .lastName(savedStudent.getLastName())
                .email(savedStudent.getEmail())
                .build();
    }

    @Override
    public void deleteStudentById(Long id) {
        studentsRepo.deleteById(id);

    }
}

