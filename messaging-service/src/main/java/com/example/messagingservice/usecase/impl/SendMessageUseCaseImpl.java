package com.example.messagingservice.usecase.impl;

import com.example.messagingservice.dto.GetMessagesResponse;
import com.example.messagingservice.dto.SendMessageRequest;
import com.example.messagingservice.dto.SendMessageResponse;
import com.example.messagingservice.service.KafkaMessagingService;
import com.example.messagingservice.service.MessageDataAccessService;
import com.example.messagingservice.usecase.SendMessageUseCase;
import com.example.messagingservice.util.converters.MessageModelConverter;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

/**
 * @author Zairov Aziz
 * @date 07.10.2023
 **/

@Component
public class SendMessageUseCaseImpl implements SendMessageUseCase {

    private final KafkaMessagingService kafkaMessagingService;
    private final MessageDataAccessService messageDataAccessService;

    public SendMessageUseCaseImpl(
            KafkaMessagingService kafkaMessagingService, MessageDataAccessService messageDataAccessService) {

        this.kafkaMessagingService = kafkaMessagingService;
        this.messageDataAccessService = messageDataAccessService;
    }

    @Override
    public SendMessageResponse sendMessage(SendMessageRequest request) {

        kafkaMessagingService.send(MessageModelConverter.dtoToModel(request));
        messageDataAccessService.createMessage(request);
        return SendMessageResponse
                .builder()
                .status(HttpStatus.OK.name())
                .build();
    }

    @Override
    public GetMessagesResponse getMessages(String sender) {

        return GetMessagesResponse
                .builder()
                .messages(
                        messageDataAccessService.getMessages(sender)
                                .stream()
                        .map(MessageModelConverter::entityToModel)
                        .collect(Collectors.toList())
                )
                .build();
    }
}
