package com.example.messagingreceiver.config;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * @author Zairov Aziz
 * @date 08.10.2023
 **/

@Getter
@Configuration
public class MailServerConfig {

    @Value("${mail.to}")
    private String emailReceiver;

    @Value("${mail.host}")
    private String host;

    @Value("${mail.port}")
    private String port;

    @Value("${mail.username}")
    private String username;

    @Value("${mail.password}")
    private String password;

    @Value("${mail.properties.mail.smtp.auth}")
    private String mailSmtpAuth;

    @Value("${mail.properties.mail.smtp.starttls.enable}")
    private String mailSmtpStarttlsEnable;

}
