package com.example.messagingservice.exception;

/**
 * @author Zairov Aziz
 * @date 07.10.2023
 **/

public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException(String message) {
        super(message);
    }

}
