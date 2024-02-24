package com.cst8277.messagingservice.repository;

import com.cst8277.messagingservice.entity.Producer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.UUID;

public interface ProducerRepository extends JpaRepository<Producer, UUID> {
    @Query("SELECT p FROM Producer p WHERE p.id = :id")
    Producer findByIdCustom(@Param("id") UUID id);
}