package com.ozgurucar.jpa.repositories;

import com.ozgurucar.jpa.models.Author;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AuthorRepository extends JpaRepository<Author, Integer>, JpaSpecificationExecutor<Author> {

    @Transactional
    List<Author> findByNamedQuery(@Param("age") int age);


    // update Author a set a.age = 22 where a.id = 1

    @Modifying
    @Transactional
    @Query("update Author a set a.age = :age where a.id = :id")
            int updateAuthorBy(int age, int id);

    @Modifying
    @Transactional
    @Query("update  Author a set a.age = :age")
            void updateAllAuthorsAges(int age);

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
