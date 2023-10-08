package com.example.messagingservice.dto;

import com.example.messagingservice.model.Message;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import lombok.Builder;
import lombok.Data;
import java.util.List;


/**
 * @author Zairov Aziz
 * @date 07.10.2023
 **/

@Builder
@Data
public class GetMessagesResponse {

    @JacksonXmlElementWrapper(localName = "Messages")
    @JacksonXmlProperty(localName = "Message")
    private List<Message> messages;
}
