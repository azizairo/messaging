package com.example.messagingservice.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

/**
 * @author Zairov Aziz
 * @date 07.10.2023
 **/

@Configuration
public class KafkaTopicConfiguration {

    @Bean
    public NewTopic sendMessageTopic(AppConfig appConfig) {

        return TopicBuilder
                .name(appConfig.getSendMessageTopicName())
                .build();
    }

}
