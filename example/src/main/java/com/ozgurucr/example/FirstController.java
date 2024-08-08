package com.ozgurucr.example;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class FirstController {

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
}
