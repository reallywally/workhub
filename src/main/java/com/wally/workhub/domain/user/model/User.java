package com.wally.workhub.domain.user.model;

import com.wally.workhub.domain.auth.model.Session;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String email;
    private String password;
    private LocalDateTime createdAt;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private List<Session> sessions = new ArrayList<>();  // 지금은 우선 이렇게 연관 관계 갈어서 사용

    @Builder
    public User(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public Session addSession(){
        Session session = Session.builder()
                .user(this)
                .build();
        sessions.add(session)
        ;
        return session;
    }

    public void setPassword(String encodePassword) {
        password = encodePassword;
    }
}