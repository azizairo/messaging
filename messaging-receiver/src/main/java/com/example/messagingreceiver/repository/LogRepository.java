package com.example.messagingreceiver.repository;

import com.example.messagingreceiver.entity.LogEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Zairov Aziz
 * @date 08.10.2023
 **/

public interface LogRepository extends JpaRepository<LogEntity, Long> {

}
