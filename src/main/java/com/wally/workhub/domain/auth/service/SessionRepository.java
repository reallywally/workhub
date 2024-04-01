package com.wally.workhub.domain.auth.service;

import com.wally.workhub.domain.auth.model.Session;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SessionRepository extends JpaRepository<Session, Long> {
}
