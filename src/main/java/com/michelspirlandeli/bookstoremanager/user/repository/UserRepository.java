package com.michelspirlandeli.bookstoremanager.user.repository;

import com.michelspirlandeli.bookstoremanager.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
