package com.tjpark.chatapp.domain.chat.domain;


import com.tjpark.chatapp.domain.member.domain.Member;
import com.tjpark.chatapp.domain.member.domain.Role;
import com.tjpark.chatapp.global.common.BaseTimeEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Entity
@Table(name = "chat_room_members")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ChatRoomMember extends BaseTimeEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "chat_room_id", nullable = false)
    private ChatRoom chatRoom;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private Member member;

    @Enumerated(EnumType.STRING)
    @Column(name = "member_role", nullable = false, length = 20)
    private Role role = Role.MEMBER;

    @Column(name = "notification_enabled")
    private boolean notificationEnabled = true;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "last_read_message_id")
    private ChatMessage lastReadMessage;

    @Column(name = "joined_at")
    private LocalDateTime joinedAt = LocalDateTime.now();
}
