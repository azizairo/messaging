package com.example.messagingservice.usecase;


import com.example.messagingservice.dto.GetMessagesResponse;
import com.example.messagingservice.dto.SendMessageRequest;
import com.example.messagingservice.dto.SendMessageResponse;

/**
    @author  Zairov Aziz
    @date  07.10.2023
**/

public interface SendMessageUseCase {

    SendMessageResponse sendMessage(SendMessageRequest request);

    GetMessagesResponse getMessages(String sender);

}
