package com.sudip.websocket.chat;

import java.sql.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
@Builder
@Document
public class ChatMessage {
    @Id
    private String id;

    private String chatId;
    private String senderId;
    private String recipientId;
    private String content;
    private Date timestamp;

}
