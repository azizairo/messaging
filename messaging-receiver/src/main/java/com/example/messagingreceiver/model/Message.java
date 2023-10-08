package com.example.messagingreceiver.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Zairov Aziz
 * @date 08.10.2023
 **/

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Message {

    private String sender;
    private String message;
}
