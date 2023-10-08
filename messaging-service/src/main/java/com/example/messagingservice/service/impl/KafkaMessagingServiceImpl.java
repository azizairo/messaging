package com.example.messagingservice.service.impl;

import com.example.messagingservice.config.AppConfig;
import com.example.messagingservice.model.Message;
import com.example.messagingservice.service.KafkaMessagingService;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

/**
 * @author Zairov Aziz
 * @date 07.10.2023
 **/

@Service
public class KafkaMessagingServiceImpl implements KafkaMessagingService {

    private final AppConfig appConfig;
    private final KafkaTemplate<String, Message> kafkaTemplate;

    public KafkaMessagingServiceImpl(
            AppConfig appConfig, KafkaTemplate<String, Message> kafkaTemplate
    ) {
        this.appConfig = appConfig;
        this.kafkaTemplate = kafkaTemplate;
    }

    @Override
    public void send(Message message) {

        kafkaTemplate.send(appConfig.getSendMessageTopicName(), message);
    }
}
