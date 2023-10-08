package com.example.messagingservice.service;

import com.example.messagingservice.model.Message;

/**
 * @author Zairov Aziz
 * @date 07.10.2023
 **/

public interface KafkaMessagingService {

    void send(Message message);

}
