package com.ozgurucr.example;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Integer> {

    List<Student> findAllByFirstNameContaining (String firstname);

    boolean existsByEmail(String email);
}
