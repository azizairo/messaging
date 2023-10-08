package com.example.messagingreceiver.usecase;

import com.example.messagingreceiver.model.Message;

/**
 * @author Zairov Aziz
 * @date 08.10.2023
 **/

public interface SendEmailAndSaveResponseUseCase {

    void sendEmail(Message message);

}
