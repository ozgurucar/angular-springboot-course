package com.ozgurucr.example.student;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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

    public List<StudentRespondeDto> getAllStudents() {
        return studentRepository.findAll().stream().map(studentMapper::toStudentRespondeDto).collect(Collectors.toList());

    }

    public StudentRespondeDto getStudentById(int id) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new StudentNotFoundException("Student not found with id: " + id));
        return studentMapper.toStudentRespondeDto(student);
    }

    public List<StudentRespondeDto> getStudentsByName(String name) {
        return studentRepository.findAllByFirstNameContaining(name).stream().map(studentMapper::toStudentRespondeDto).collect(Collectors.toList());
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
