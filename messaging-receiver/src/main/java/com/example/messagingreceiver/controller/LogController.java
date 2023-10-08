package com.example.messagingreceiver.controller;

import com.example.messagingreceiver.dto.GetLogsResponse;
import com.example.messagingreceiver.service.LogDataAccessService;
import com.example.messagingreceiver.util.converter.LogModelConverter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.stream.Collectors;

/**
 * @author Zairov Aziz
 * @date 08.10.2023
 **/

@RestController
@RequestMapping("api/v1/logs")
public class LogController {

    private final LogDataAccessService logDataAccessService;

    public LogController(LogDataAccessService logDataAccessService) {
        this.logDataAccessService = logDataAccessService;
    }

    @GetMapping
    public GetLogsResponse getLogs() {

        return GetLogsResponse
                .builder()
                .logs(
                        logDataAccessService.getLogs()
                                .stream()
                                .map(LogModelConverter::convertEntityToDto)
                                .collect(Collectors.toList())
                )
                .build();
    }
}
