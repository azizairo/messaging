package com.example.messagingreceiver.dto;

import lombok.Builder;
import lombok.Data;

/**
 * @author Zairov Aziz
 * @date 08.10.2023
 **/

@Builder
@Data
public class LogDto {

    private String messageBody;
    private Integer responseCode;
}
