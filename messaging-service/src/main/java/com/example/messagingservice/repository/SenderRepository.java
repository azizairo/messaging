package com.example.messagingservice.repository;

import com.example.messagingservice.entity.SenderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Zairov Aziz
 * @date 07.10.2023
 **/

public interface SenderRepository extends JpaRepository<SenderEntity, String> {

}
