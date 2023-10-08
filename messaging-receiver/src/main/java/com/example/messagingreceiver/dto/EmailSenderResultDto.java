package com.example.messagingreceiver.dto;

import lombok.Builder;
import lombok.Data;

/**
 * @author Zairov Aziz
 * @date 08.10.2023
 **/

@Data
@Builder
public class EmailSenderResultDto {

    private Integer responseCode;
}
