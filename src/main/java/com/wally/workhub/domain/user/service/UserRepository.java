package com.wally.workhub.domain.user.service;

import com.wally.workhub.domain.user.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
    User findByEmail(String email);

    Optional<User> findByEmailAndPassword(String email, String password);
}
