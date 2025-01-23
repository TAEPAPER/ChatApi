package com.tjpark.chatapp.domain.chat.domain;
import lombok.Getter;

@Getter
public enum RoomType {
    PUBLIC("공개방"),
    PRIVATE("비공개방"),
    GROUP("그룹방");

    private final String description;

    RoomType(String description) {
        this.description = description;
    }
}
