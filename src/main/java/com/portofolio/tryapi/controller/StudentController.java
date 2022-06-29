package com.portofolio.tryapi.controller;

import com.portofolio.tryapi.dtos.StudentRequest;
import com.portofolio.tryapi.dtos.StudentResponse;
import com.portofolio.tryapi.service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/students")
@AllArgsConstructor
public class StudentController {
    private StudentService studentService;

    @GetMapping
    public List<StudentResponse> getAllStudent() {
        return studentService.getAllStudent();
    }
    @PostMapping
    public StudentResponse saveStudent(@RequestBody StudentRequest studentRequest) {
        return studentService.saveStudent(studentRequest);
    }
    @PutMapping(value = "/{id}")
    public StudentResponse updateStudent(@PathVariable(value = "id") Long id, @RequestBody StudentRequest studentRequest) {
        return studentService.updateStudent(id, studentRequest);
    }
    @GetMapping(value = "/{id}")
    public Optional<StudentResponse> getStudentById(@PathVariable(value = "id") Long id) {
        return studentService.getStudentById(id);
    }
    @DeleteMapping(value = "/{id}")
    void deleteStudentById(@PathVariable Long id) {
        studentService.deleteStudentById(id);
    }

}


