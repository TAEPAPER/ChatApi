package com.tjpark.chatapp.domain.chat.domain;

import com.tjpark.chatapp.domain.member.domain.Member;
import com.tjpark.chatapp.global.common.BaseTimeEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "chat_rooms")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ChatRoom extends BaseTimeEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "chat_room_id")
    private Long id;

    @Column(name = "room_name", nullable = false, length = 100)
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(name = "room_type", nullable = false, length = 20)
    private RoomType type;

    @Column(name = "max_members")
    private int maxMembers = 100;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "creator_user_id", nullable = false)
    private Member creator;

    @OneToMany(mappedBy = "chatRoom", cascade = CascadeType.ALL)
    private List<ChatRoomMember> members = new ArrayList<>();
}
