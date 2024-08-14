package com.ozgurucar.jpa.repositories;

import com.ozgurucar.jpa.models.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Integer> {
}
