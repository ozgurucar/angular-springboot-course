package com.ozgurucr.example;

import com.ozgurucr.example.student.StudentRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

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


}
