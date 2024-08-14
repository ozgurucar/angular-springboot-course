package com.ozgurucar.jpa;

import com.ozgurucar.jpa.models.Author;
import com.ozgurucar.jpa.repositories.AuthorRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.DateTimeException;
import java.time.LocalDateTime;

@SpringBootApplication
public class JpaApplication {

    public static void main(String[] args) {
        SpringApplication.run(JpaApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(
            AuthorRepository repository
    ) {
        return args -> {
            var author = Author.builder().firstName("ozgur").lastName("ucar").age(22).email("ozgur.ucar@outlook.com").build();
                repository.save(author);


        };
    }
}
