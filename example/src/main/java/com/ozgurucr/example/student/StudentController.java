package com.ozgurucr.example.student;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.View;

import java.util.HashMap;
import java.util.List;

@RestController
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService, View error) {
        this.studentService = studentService;
    }

    @PostMapping("/students")
    public StudentRespondeDto saveStudent(@Valid @RequestBody StudentDto dto) {
        return this.studentService.saveStudent(dto);
    }


    @GetMapping("/students")
    public List<StudentRespondeDto> getAllStudents() {
        return studentService.getAllStudents();
    }

    @GetMapping("students/{student-id}")
    public Student findStudentById(@PathVariable("student-id") Integer id) {
        return studentService.getStudentById(id);
    }


    @GetMapping("findstudents/{student-id}")
    public String findStudentByIdString(@PathVariable("student-id") Integer id) {
        Student student = studentService.getStudentById(id);
        return "Student id : " + student.getId() + "<br>Student name : " + student.getFirstName() + "<br>Student last-name : " + student.getLastName();
    }

    @GetMapping("students/search/{student-name}")
    public List<StudentRespondeDto> findStudentByName(@PathVariable("student-name") String name) {
        return studentService.getStudentsByName(name);
    }

    @DeleteMapping("students/{student-id}")
    public ResponseEntity<String> deleteStudent(@PathVariable("student-id") Integer id) {
        return studentService.deleteStudentById(id);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> handleValidationNotValidException(MethodArgumentNotValidException exp) {
        var errors = new HashMap<String, String>();
        exp.getBindingResult().getAllErrors().forEach(error -> {
            var fieldName = ((FieldError) error).getField();
            var errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }
}
