package com.ozgurucr.example;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {
private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping("/students")
    public StudentRespondeDto saveStudent(@RequestBody StudentDto dto) {
       return this.studentService.saveStudent(dto);
    }


    @GetMapping("/students")
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    @GetMapping("students/{student-id}")
    public Student findStudentById(@PathVariable("student-id") Integer id) {
        return studentService.getStudentById(id);
    }

    @GetMapping("students/search/{student-name}")
    public List<Student> findStudentByName(@PathVariable("student-name") String name) {
        return studentService.getStudentsByName(name);
    }

    @DeleteMapping("students/{student-id}")
    public ResponseEntity<String> deleteStudent(@PathVariable("student-id") Integer id) {
       return studentService.deleteStudentById(id);
    }
}
