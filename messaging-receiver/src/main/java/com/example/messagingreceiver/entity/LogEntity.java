package com.example.messagingreceiver.entity;

import com.example.messagingreceiver.constants.ColumnNames;
import com.example.messagingreceiver.constants.SequenceNames;
import com.example.messagingreceiver.constants.TableNames;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Zairov Aziz
 * @date 08.10.2023
 **/

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = TableNames.TABLE_NAME_LOG)
public class LogEntity {

    @Id
    @SequenceGenerator(
            name = SequenceNames.LOG_ID_SEQUENCE_NAME,
            sequenceName = SequenceNames.LOG_ID_SEQUENCE_NAME
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = SequenceNames.LOG_ID_SEQUENCE_NAME
    )
    @Column(name = ColumnNames.LOG_COLUMN_NAME_ID)
    private Long id;

    @Column(name = ColumnNames.LOG_COLUMN_NAME_MESSAGE_BODY, nullable = false)
    private String messageBody;

    @Column(name = ColumnNames.LOG_COLUMN_NAME_RESPONSE_CODE, nullable = false)
    private Integer responseCode;

}
