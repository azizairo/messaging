package com.example.messagingreceiver.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

/**
 * @author Zairov Aziz
 * @date 08.10.2023
 **/

@Builder
@Data
public class GetLogsResponse {

    private List<LogDto> logs;
}
