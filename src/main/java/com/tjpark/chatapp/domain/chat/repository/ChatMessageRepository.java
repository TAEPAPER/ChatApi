package com.tjpark.chatapp.domain.chat.repository;

import com.tjpark.chatapp.domain.chat.domain.ChatMessage;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ChatMessageRepository extends JpaRepository<ChatMessage, Long> {
    Page<ChatMessage> findByChatRoomIdAndIsDeletedFalseOrderByCreatedAtDesc(Long roomId, Pageable pageable);

    /**
     * countByChatRoomIdAndIdGreaterThanAndIsDeletedFalse
     *
     * count -> 개수를 센다
     * By -> ~로
     * ChatRoomId -> 채팅방 아이디가
     * And -> 그리고
     * Id -> 메시지 아이디가
     * GreaterThan -> 초과하는
     * And -> 그리고
     * IsDeletedFalse -> 삭제되지 않은
     *
     * -> "특정 채팅방에서, 마지막으로 읽은 메시지 ID 이후의, 삭제되지 않은 메시지 개수를 센다"
     *
     * 예시: roomId가 1이고 lastReadMessageId가 100이면
     * 1번 채팅방의 message_id가 100보다 크고 삭제되지 않은 메시지의 개수를 반환
     * (즉, 아직 읽지 않은 메시지의 개수)
     */
    long countByChatRoomIdAndIdGreaterThanAndIsDeletedFalse(Long roomId, Long lastReadMessageId);
    List<ChatMessage> findTop100ByChatRoomIdOrderByCreatedAtDesc(Long roomId);
}
