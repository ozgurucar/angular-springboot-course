package com.ozgurucar.jpa;

import com.ozgurucar.jpa.models.Author;
import com.ozgurucar.jpa.models.Video;
import com.ozgurucar.jpa.repositories.AuthorRepository;
import com.ozgurucar.jpa.repositories.VideoRepository;
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
            AuthorRepository repository,
            VideoRepository videoRepository
    ) {
        return args -> {
/*            var author = Author.builder().firstName("ozgur").lastName("ucar").age(22).email("ozgur.ucar@outlook.com").build();
                repository.save(author);*/

            var video = Video.builder().
                    name("abc").
                    length(5)
                    .build();
            videoRepository.save(video);

        };
    }
}
