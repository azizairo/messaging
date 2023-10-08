package com.example.messagingservice.controller;

import com.example.messagingservice.dto.ErrorResponse;
import com.example.messagingservice.dto.GetMessagesResponse;
import com.example.messagingservice.dto.SendMessageRequest;
import com.example.messagingservice.dto.SendMessageResponse;
import com.example.messagingservice.exception.ResourceNotFoundException;
import com.example.messagingservice.usecase.SendMessageUseCase;
import jakarta.validation.Valid;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

/**
 * @author Zairov Aziz
 * @date 07.10.2023
 **/

@RestController
@RequestMapping("api/v1/messages")
public class MessagingController {

    private final SendMessageUseCase sendMessageUseCase;

    public MessagingController(SendMessageUseCase sendMessageUseCase) {
        this.sendMessageUseCase = sendMessageUseCase;
    }

    @PostMapping()
    public SendMessageResponse sendMessage(@RequestBody @Valid SendMessageRequest request) {

        return sendMessageUseCase.sendMessage(request);
    }

    @GetMapping()
    public GetMessagesResponse getMessages(
            @RequestParam(value = "sender", required = false) String sender) {

        return sendMessageUseCase.getMessages(sender);
    }

    @Order(Ordered.HIGHEST_PRECEDENCE)
    @ExceptionHandler(ResourceNotFoundException.class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    private ErrorResponse handleResourceNotFoundException(
            ResourceNotFoundException exception) {

        return ErrorResponse
                .builder()
                .status(HttpStatus.NOT_FOUND.name())
                .errorMessage(exception.getMessage())
                .build();
    }

    @Order(Ordered.HIGHEST_PRECEDENCE)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    private ErrorResponse handleBadRequestException(MethodArgumentNotValidException exception) {

        return ErrorResponse
                .builder()
                .status(HttpStatus.BAD_REQUEST.name())
                .errorMessage(exception.getMessage())
                .build();
    }

}
