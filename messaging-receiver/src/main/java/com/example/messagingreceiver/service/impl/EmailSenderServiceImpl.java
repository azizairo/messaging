package com.example.messagingreceiver.service.impl;

import com.example.messagingreceiver.config.MailServerConfig;
import com.example.messagingreceiver.dto.EmailSenderDto;
import com.example.messagingreceiver.dto.EmailSenderResultDto;
import com.example.messagingreceiver.service.EmailSenderService;
import com.sun.mail.smtp.SMTPTransport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

/**
 * @author Zairov Aziz
 * @date 08.10.2023
 **/

@Service
public class EmailSenderServiceImpl implements EmailSenderService {

    private static final String SMTP_PROTOCOL = "smtp";
    private static final String SUBJECT = "subject";

    private final MailServerConfig mailServerConfig;

    @Autowired
    public EmailSenderServiceImpl(MailServerConfig mailServerConfig) {
        this.mailServerConfig = mailServerConfig;
    }

    @Override
    public EmailSenderResultDto sendEmail(EmailSenderDto emailSenderDto) {

        EmailSenderResultDto.EmailSenderResultDtoBuilder builder = EmailSenderResultDto.builder();
        try {
            Session session = Session.getInstance(getMailServerProperties(), new Authenticator() {
                @Override
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(mailServerConfig.getUsername(), mailServerConfig.getPassword());
                }
            });

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(emailSenderDto.getSender()));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(mailServerConfig.getEmailReceiver()));
            message.setSubject(SUBJECT);
            message.setText(emailSenderDto.getMessage());

            SMTPTransport transport = (SMTPTransport) session.getTransport(SMTP_PROTOCOL);
            try(transport) {
                transport.connect();
                transport.sendMessage(message, message.getAllRecipients());
                builder.responseCode(transport.getLastReturnCode());
            } catch (MessagingException exception) {
                builder.responseCode(transport.getLastReturnCode());
            }
        } catch (MessagingException e) {
            builder.responseCode(-1);
        }
        return builder.build();
    }

    private Properties getMailServerProperties() {

        Properties properties = new Properties();
        properties.put("mail.smtp.auth", mailServerConfig.getMailSmtpAuth());
        properties.put("mail.smtp.starttls.enable", mailServerConfig.getMailSmtpStarttlsEnable());
        properties.put("mail.smtp.host", mailServerConfig.getHost());
        properties.put("mail.smtp.port", mailServerConfig.getPort());
        return properties;
    }
}
