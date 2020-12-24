package com.michelspirlandeli.bookstoremanager.author.repository;

import com.michelspirlandeli.bookstoremanager.author.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Long> {
}
