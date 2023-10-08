package com.example.messagingreceiver.service.impl;

import com.example.messagingreceiver.dto.EmailSenderResultDto;
import com.example.messagingreceiver.entity.LogEntity;
import com.example.messagingreceiver.repository.LogRepository;
import com.example.messagingreceiver.service.LogDataAccessService;
import com.example.messagingreceiver.util.converter.EmailSenderDtoConverter;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Zairov Aziz
 * @date 08.10.2023
 **/

@Service
public class LogDataAccessServiceImpl implements LogDataAccessService {

    private final LogRepository repository;

    public LogDataAccessServiceImpl(LogRepository repository) {
        this.repository = repository;
    }

    @Override
    public void saveSendEmailResult(EmailSenderResultDto resultDto, String messageBody) {

        repository.save(EmailSenderDtoConverter.convertDtoToEntity(resultDto, messageBody));
    }

    @Override
    public List<LogEntity> getLogs() {

        return repository.findAll();
    }
}
