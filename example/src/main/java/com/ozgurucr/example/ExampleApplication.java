package com.ozgurucr.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class ExampleApplication {

	public static void main(String[] args) {
		var context = SpringApplication.run(ExampleApplication.class, args);
		MyFirstService myFirstService = context.getBean(MyFirstService.class);
		System.out.println(myFirstService.tellAStory());
		System.out.println(myFirstService.getDeviceName());
		System.out.println(myFirstService.getJavaVersion());
		System.out.println(myFirstService.getCustomProperty());

	}
}
