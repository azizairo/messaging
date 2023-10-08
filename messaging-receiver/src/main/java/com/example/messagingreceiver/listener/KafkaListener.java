package com.example.messagingreceiver.listener;

import com.example.messagingreceiver.model.Message;
import com.example.messagingreceiver.usecase.SendEmailAndSaveResponseUseCase;
import org.springframework.stereotype.Component;

/**
 * @author Zairov Aziz
 * @date 08.10.2023
 **/

@Component
public class KafkaListener {

    private final SendEmailAndSaveResponseUseCase sendEmailAndSaveResponseUseCase;

    public KafkaListener(SendEmailAndSaveResponseUseCase sendEmailAndSaveResponseUseCase) {
        this.sendEmailAndSaveResponseUseCase = sendEmailAndSaveResponseUseCase;
    }

    @org.springframework.kafka.annotation.KafkaListener(
            topics = "${kafka.topic.name}",
            groupId = "message-receiver",
            containerFactory = "factory"
    )
    public void listener(Message data) {

        sendEmailAndSaveResponseUseCase.sendEmail(data);
    }

}
