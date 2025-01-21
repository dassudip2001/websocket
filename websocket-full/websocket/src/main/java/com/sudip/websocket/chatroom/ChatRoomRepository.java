package com.sudip.websocket.chatroom;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface ChatRoomRepository extends MongoRepository<ChatRoom, String> {

    Optional<String> findBySenderIdAndRecipientId(String senderId, String recipientId);

}
