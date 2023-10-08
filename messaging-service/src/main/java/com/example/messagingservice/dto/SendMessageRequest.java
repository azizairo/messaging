package com.example.messagingservice.dto;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Zairov Aziz
 * @date 07.10.2023
 **/

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SendMessageRequest {

    @JacksonXmlProperty(localName = "Sender")
    @NotBlank
    private String sender;

    @JacksonXmlProperty(localName = "Message")
    @NotBlank
    private String message;
}
