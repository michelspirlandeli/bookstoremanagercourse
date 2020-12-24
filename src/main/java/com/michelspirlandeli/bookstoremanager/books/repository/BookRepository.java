package com.michelspirlandeli.bookstoremanager.books.repository;

import com.michelspirlandeli.bookstoremanager.books.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
