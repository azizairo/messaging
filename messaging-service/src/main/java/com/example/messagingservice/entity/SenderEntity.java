package com.example.messagingservice.entity;

import com.example.messagingservice.constants.ColumnNames;
import com.example.messagingservice.constants.TableNames;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Zairov Aziz
 * @date 07.10.2023
 **/

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = TableNames.TABLE_NAME_SENDER)
public class SenderEntity {

    @Id
    @Column(name = ColumnNames.SENDER_COLUMN_NAME_SENDER)
    private String sender;


}
