package com.wally.workhub.domain.user.service;

import com.wally.workhub.domain.user.model.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<AppUser, Long> {
    AppUser findByUsername(String username);
    AppUser findByEmail(String email);

    Optional<AppUser> findByEmailAndPassword(String email, String password);
}
