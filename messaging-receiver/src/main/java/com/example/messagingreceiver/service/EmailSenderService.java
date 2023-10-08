package com.example.messagingreceiver.service;

import com.example.messagingreceiver.dto.EmailSenderDto;
import com.example.messagingreceiver.dto.EmailSenderResultDto;

/**
 * @author Zairov Aziz
 * @date 08.10.2023
 **/

public interface EmailSenderService {

    EmailSenderResultDto sendEmail(EmailSenderDto request);

}
