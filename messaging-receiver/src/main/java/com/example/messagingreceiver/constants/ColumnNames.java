package com.example.messagingreceiver.constants;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * @author Zairov Aziz
 * @date 08.10.2023
 **/

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class ColumnNames {

    public static final String LOG_COLUMN_NAME_ID = "id";
    public static final String LOG_COLUMN_NAME_MESSAGE_BODY = "message_body";
    public static final String LOG_COLUMN_NAME_RESPONSE_CODE = "response_code";
}
