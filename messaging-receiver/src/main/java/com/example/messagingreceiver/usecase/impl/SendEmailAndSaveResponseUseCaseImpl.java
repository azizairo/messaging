package com.example.messagingreceiver.usecase.impl;

import com.example.messagingreceiver.dto.EmailSenderResultDto;
import com.example.messagingreceiver.model.Message;
import com.example.messagingreceiver.service.EmailSenderService;
import com.example.messagingreceiver.service.LogDataAccessService;
import com.example.messagingreceiver.usecase.SendEmailAndSaveResponseUseCase;
import com.example.messagingreceiver.util.converter.EmailSenderDtoConverter;
import org.springframework.stereotype.Component;

/**
 * @author Zairov Aziz
 * @date 08.10.2023
 **/

@Component
public class SendEmailAndSaveResponseUseCaseImpl implements SendEmailAndSaveResponseUseCase {

    private final EmailSenderService emailSenderService;
    private final LogDataAccessService logDataAccessService;

    public SendEmailAndSaveResponseUseCaseImpl(
            EmailSenderService emailSenderService, LogDataAccessService logDataAccessService) {
        this.emailSenderService = emailSenderService;
        this.logDataAccessService = logDataAccessService;
    }

    @Override
    public void sendEmail(Message message) {

        EmailSenderResultDto resultDto = emailSenderService.sendEmail(EmailSenderDtoConverter.convertModelToDto(message));
        logDataAccessService.saveSendEmailResult(resultDto, message.getMessage());
    }
}
