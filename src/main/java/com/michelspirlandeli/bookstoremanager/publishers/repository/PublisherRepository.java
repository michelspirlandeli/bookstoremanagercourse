package com.michelspirlandeli.bookstoremanager.publishers.repository;

import com.michelspirlandeli.bookstoremanager.publishers.entity.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PublisherRepository extends JpaRepository<Publisher, Long> {
}
