package com.example.messagingreceiver.service;

import com.example.messagingreceiver.dto.EmailSenderResultDto;
import com.example.messagingreceiver.entity.LogEntity;

import java.util.List;

/**
 * @author Zairov Aziz
 * @date 08.10.2023
 **/

public interface LogDataAccessService {

        void saveSendEmailResult(EmailSenderResultDto resultDto, String messageBody);

        List<LogEntity> getLogs();
}
