package com.ozgurucar.jpa;

import com.github.javafaker.Faker;
import com.ozgurucar.jpa.models.Author;
import com.ozgurucar.jpa.repositories.AuthorRepository;
import com.ozgurucar.jpa.repositories.VideoRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class JpaApplication {

    public static void main(String[] args) {
        SpringApplication.run(JpaApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(
            AuthorRepository repository,
            VideoRepository videoRepository
    ) {
        return args -> {
           /* for (int i = 0; i < 50; i++) {
                Faker faker = new Faker();
                var f_Name = faker.name().firstName();
                var l_Name = faker.name().lastName();
                var author = Author.builder().firstName(f_Name).lastName(l_Name).age(faker.number().numberBetween(19,80)).email(f_Name+l_Name+"@test.com").build();
                repository.save(author);

            }*/


           /* var video = Video.builder().
                    name("abc").
                    length(5)
                    .build();
            videoRepository.save(video);*/

        };
    }
}
