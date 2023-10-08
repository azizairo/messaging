package com.example.messagingreceiver.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

/**
 * @author Zairov Aziz
 * @date 08.10.2023
 **/

@Builder
@Data
@AllArgsConstructor
public class EmailSenderDto {

    private String sender;
    private String message;

}
