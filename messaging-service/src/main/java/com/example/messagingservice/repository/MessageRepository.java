package com.example.messagingservice.repository;

import com.example.messagingservice.entity.MessageEntity;
import com.example.messagingservice.entity.SenderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * @author Zairov Aziz
 * @date 07.10.2023
 **/

public interface MessageRepository extends JpaRepository<MessageEntity, Long> {

    List<MessageEntity> findAllBySenderEntity(@Param("sender") SenderEntity senderEntity);

    List<MessageEntity> findTop10ByOrderByCreatedAtDesc();
}
