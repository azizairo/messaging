package com.example.messagingservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Zairov Aziz
 * @date 07.10.2023
 **/

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class SendMessageResponse {

    private String status;
}
