package com.example.messagingservice.util.converters;

import com.example.messagingservice.dto.SendMessageRequest;
import com.example.messagingservice.entity.MessageEntity;
import com.example.messagingservice.model.Message;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * @author Zairov Aziz
 * @date 07.10.2023
 **/

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class MessageModelConverter {

    public static Message dtoToModel(SendMessageRequest sendMessageRequest) {

        return Message
                .builder()
                .sender(sendMessageRequest.getSender())
                .message(sendMessageRequest.getMessage())
                .build();
    }

    public static Message entityToModel(MessageEntity messageEntity) {

        return Message
                .builder()
                .sender(messageEntity.getSenderEntity().getSender())
                .message(messageEntity.getMessage())
                .build();
    }

}
