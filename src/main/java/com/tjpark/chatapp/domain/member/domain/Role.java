package com.tjpark.chatapp.domain.member.domain;

import lombok.Getter;

@Getter
public enum Role {
    OWNER("방장"),
    ADMIN("관리자"),
    MEMBER("일반멤버");

    private final String description;

    Role(String description) {
        this.description = description;
    }
}
