package com.example.messagingreceiver.util.converter;

import com.example.messagingreceiver.dto.LogDto;
import com.example.messagingreceiver.entity.LogEntity;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * @author Zairov Aziz
 * @date 08.10.2023
 **/

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class LogModelConverter {

    public static LogDto convertEntityToDto(LogEntity entity) {

        return LogDto
                .builder()
                .messageBody(entity.getMessageBody())
                .responseCode(entity.getResponseCode())
                .build();
    }

}
