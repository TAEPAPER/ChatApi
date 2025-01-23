package com.tjpark.chatapp.domain.chat.repository;


import com.tjpark.chatapp.domain.chat.domain.ChatRoom;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ChatRoomRepository extends JpaRepository<ChatRoom, Long> {
    List<ChatRoom> findByMembersMemberId(Long memberId);
    int countByMembersChatRoomId(Long roomId);
}
