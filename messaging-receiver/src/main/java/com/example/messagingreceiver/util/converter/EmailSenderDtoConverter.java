package com.example.messagingreceiver.util.converter;

import com.example.messagingreceiver.dto.EmailSenderDto;
import com.example.messagingreceiver.dto.EmailSenderResultDto;
import com.example.messagingreceiver.entity.LogEntity;
import com.example.messagingreceiver.model.Message;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * @author Zairov Aziz
 * @date 08.10.2023
 **/

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class EmailSenderDtoConverter {

    public static LogEntity convertDtoToEntity(EmailSenderResultDto emailSenderResultDto, String messageBody) {

        return LogEntity
                .builder()
                .messageBody(messageBody)
                .responseCode(emailSenderResultDto.getResponseCode())
                .build();
    }

    public static EmailSenderDto convertModelToDto(Message message) {

        return EmailSenderDto
                .builder()
                .sender(message.getSender())
                .message(message.getMessage())
                .build();
    }

}
