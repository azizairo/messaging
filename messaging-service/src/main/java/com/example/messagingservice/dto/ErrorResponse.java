package com.example.messagingservice.dto;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import lombok.Builder;
import lombok.Data;

/**
 * @author Zairov Aziz
 * @date 07.10.2023
 **/

@Builder
@Data
public class ErrorResponse {

    @JacksonXmlProperty(localName = "Status")
    private String status;

    @JacksonXmlProperty(localName = "ErrorMessage")
    private String errorMessage;
}
