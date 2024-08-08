package com.ozgurucr.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class ExampleApplication {

	public static void main(String[] args) {
		var context = SpringApplication.run(ExampleApplication.class, args);
		MyFirstClass myFirstClass = context.getBean(MyFirstClass.class);
		System.out.println(myFirstClass.sayHello());
	}
}
