package com.ozgurucar.jpa.repositories;

import com.ozgurucar.jpa.models.Author;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AuthorRepository extends JpaRepository<Author, Integer> {

    // select * from Author where first_name = 'ali'
    List<Author> findAllByFirstNameIgnoreCase(String fn);

    // select * from Author where first_name like '%al%'
    List<Author> findAllByFirstNameContainingIgnoreCase(String fn);

    // select * from Author where first_name like 'al%'
    List<Author> findAllByFirstNameStartsWithIgnoreCase(String fn);

    // select * from Author where first_name like '%al'
    List<Author> findAllByFirstNameEndsWithIgnoreCase(String fn);

    // select * from Author where first_name in ('ali' , 'bou', 'coding')
    List<Author> findAllByFirstNameInIgnoreCase(List <String> fn);

}
