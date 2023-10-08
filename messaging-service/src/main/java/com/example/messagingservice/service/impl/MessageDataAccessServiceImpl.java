package com.example.messagingservice.service.impl;

import com.example.messagingservice.dto.SendMessageRequest;
import com.example.messagingservice.entity.MessageEntity;
import com.example.messagingservice.entity.SenderEntity;
import com.example.messagingservice.exception.ResourceNotFoundException;
import com.example.messagingservice.repository.MessageRepository;
import com.example.messagingservice.repository.SenderRepository;
import com.example.messagingservice.service.MessageDataAccessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

/**
 * @author Zairov Aziz
 * @date 07.10.2023
 **/

@Service
public class MessageDataAccessServiceImpl implements MessageDataAccessService {

    private final MessageRepository messageRepository;
    private final SenderRepository senderRepository;

    @Autowired
    public MessageDataAccessServiceImpl(MessageRepository messageRepository, SenderRepository senderRepository) {
        this.messageRepository = messageRepository;
        this.senderRepository = senderRepository;
    }

    @Transactional
    @Override
    public MessageEntity createMessage(SendMessageRequest request) {

        SenderEntity senderEntity = senderRepository.findById(request.getSender())
                .orElseGet(() -> crateNewSender(request.getSender()));

        MessageEntity.MessageEntityBuilder messageEntityBuilder = MessageEntity.builder();
        messageEntityBuilder.message(request.getMessage());
        messageEntityBuilder.senderEntity(senderEntity);

        return messageRepository.save(messageEntityBuilder.build());
    }

    @Override
    public List<MessageEntity> getMessages(String sender) {

        List<MessageEntity> result;
        if (sender != null) {
            SenderEntity senderEntity = senderRepository.findById(sender)
                    .orElseThrow(() -> new ResourceNotFoundException("Sender not found"));
            result = messageRepository.findAllBySenderEntity(senderEntity);
        } else {
            result = messageRepository.findTop10ByOrderByCreatedAtDesc();
        }
        return result;
    }

    private SenderEntity crateNewSender(String sender) {

        SenderEntity.SenderEntityBuilder builder = SenderEntity.builder();
        builder.sender(sender);
        return senderRepository.save(builder.build());
    }
}
