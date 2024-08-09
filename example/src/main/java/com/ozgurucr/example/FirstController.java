package com.ozgurucr.example;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FirstController {
    public final StudentRepository studentRepository;

    public FirstController(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }


    @GetMapping("/hello")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public String hello() {
        return "Hello World";
    }

    @GetMapping("/hello-2")
    public String hello2() {
        return "Hello World-2";
    }

    @PostMapping("/post")
    public String post(
            @RequestBody
            String message
    ) {
        return "Request Accepted " + message;
    }

    @PostMapping("/post-order")
    public String postOrder(
            @RequestBody Order order

    ) {
        return "Request Accepted and order is : " + order.getInfo();
    }

    @PostMapping("/post-order-record")
    public String postOrderRecord(
            @RequestBody OrderRecord order

    ) {
        return "Request Accepted and order is : " + order.toString();
    }

    // http://localhost:8080/hello/user-name
    @GetMapping("/hello/{user-name}")
    public String pathVariable(@PathVariable("user-name") String userName) {
        return "user name : " + userName;
    }

    // http://localhost:8080/hello?param_name=paramvalue&param_name_2=value_2
    @GetMapping("/hello-params")
    public String paramVar(
            @RequestParam("user-name") String userName,
            @RequestParam("user-lastname") String userLastname
    ) {
        return "User : " + userName + "  " + userLastname;
    }

    @PostMapping("/students")
    public ResponseEntity<?> post(@RequestBody Student student) {
        try {
            // Email'in benzersiz olup olmadığını kontrol etme
            if (studentRepository.existsByEmail(student.getEmail())) {
                throw new Exceptions.EmailAlreadyExistsException("Email already exists");
            }
            Student savedStudent = studentRepository.save(student);
            return new ResponseEntity<>(savedStudent, HttpStatus.CREATED);
        } catch (Exceptions.EmailAlreadyExistsException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/students")
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @GetMapping("students/{student-id}")
    public Student findStudentById(@PathVariable("student-id") Integer id) {
        return studentRepository.findById(id).orElse(new Student());
    }

    @GetMapping("students/search/{student-name}")
        public List<Student> findStudentByName(@PathVariable("student-name") String name) {
            return studentRepository.findAllByFirstNameContaining(name);
        }

    @DeleteMapping("students/{student-id}")
    public ResponseEntity<String> deleteStudent(@PathVariable("student-id") Integer id) {
        if (studentRepository.existsById(id)) {
            studentRepository.deleteById(id);
            return new ResponseEntity<>("Student with ID " + id + " deleted successfully.", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Student with ID " + id + " not found.", HttpStatus.NOT_FOUND);
        }
    }
}
