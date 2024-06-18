package com.wally.workhub.domain.user.model;

import lombok.Getter;

@Getter
public class UserResponse {

    private final Long id;
    private final String name;

    public UserResponse(AppUser user) {
        this.id = user.getId();
        this.name = user.getName();
    }
}
