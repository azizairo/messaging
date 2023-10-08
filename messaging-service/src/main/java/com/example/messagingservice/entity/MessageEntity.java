package com.example.messagingservice.entity;

import com.example.messagingservice.constants.ColumnNames;
import com.example.messagingservice.constants.TableNames;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Date;

/**
 * @author Zairov Aziz
 * @date 07.10.2023
 **/

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = TableNames.TABLE_NAME_MESSAGE)
public class MessageEntity {

    private static final String ID_SEQUENCE_NAME = "MESSAGE_ID_SEQUENCE";

    @Id
    @SequenceGenerator(
            name = ID_SEQUENCE_NAME,
            sequenceName = ID_SEQUENCE_NAME
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = ID_SEQUENCE_NAME
    )
    @Column(name = ColumnNames.MESSAGE_COLUMN_NAME_ID)
    private Long id;

    @ManyToOne
    @JoinColumn(name = ColumnNames.MESSAGE_COLUMN_NAME_SENDER_ID)
    private SenderEntity senderEntity;

    @Column(
            name = ColumnNames.MESSAGE_COLUMN_NAME_MESSAGE,
            nullable = false
    )
    private String message;

    @Column(
            name = ColumnNames.MESSAGE_COLUMN_NAME_CREATE_AT,
            nullable = false,
            updatable = false
    )
    @CreatedDate
    private Date createdAt;
}
