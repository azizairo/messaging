package com.example.messagingservice.service;


import com.example.messagingservice.dto.SendMessageRequest;
import com.example.messagingservice.entity.MessageEntity;

import java.util.List;

/**
 * @author Zairov Aziz
 * @date 07.10.2023
 **/

public interface MessageDataAccessService {

    MessageEntity createMessage(SendMessageRequest request);

    List<MessageEntity> getMessages(String sender);

}
