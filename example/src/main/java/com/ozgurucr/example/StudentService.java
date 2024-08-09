package com.ozgurucr.example;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    private final StudentMapper studentMapper;
    private final StudentRepository studentRepository;

    public StudentService(StudentMapper studentMapper, StudentRepository studentRepository) {
        this.studentMapper = studentMapper;
        this.studentRepository = studentRepository;
    }

    public StudentRespondeDto saveStudent(StudentDto dto) {
    var student = studentMapper.toStudent(dto);
    var savedStudent = studentRepository.save(student);
    return studentMapper.toStudentRespondeDto(savedStudent);

    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();

    }

    public Student getStudentById(int id) {
        return studentRepository.findById(id).orElse(new Student());
    }

    public List<Student> getStudentsByName(String name) {
        return studentRepository.findAllByFirstNameContaining(name);
    }

    public ResponseEntity<String> deleteStudentById(int id) {
        if (studentRepository.existsById(id)) {
            studentRepository.deleteById(id);
            return new ResponseEntity<>("Student with ID " + id + " deleted successfully.", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Student with ID " + id + " not found.", HttpStatus.NOT_FOUND);
        }
    }
}
