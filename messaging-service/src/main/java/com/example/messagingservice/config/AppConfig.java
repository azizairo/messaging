package com.example.messagingservice.config;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * @author Zairov Aziz
 * @date 07.10.2023
 **/

@Configuration
@Getter
public class AppConfig {

    @Value("${kafka.topic.name}")
    private String sendMessageTopicName;

}
