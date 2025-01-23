package com.tjpark.chatapp.domain.chat.domain;

import lombok.Getter;

@Getter
public enum MessageType {
    TEXT("일반 메시지"),
    IMAGE("이미지"),
    FILE("파일"),
    SYSTEM("시스템 메시지");  // 입장/퇴장과 같은 시스템 메시지

    private final String description;

    MessageType(String description) {
        this.description = description;
    }
}