package com.cst8277.messagingservice.repository;

import com.cst8277.messagingservice.entity.Subscriber;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.UUID;
import org.springframework.data.jpa.repository.Query;
public interface SubscriberRepository extends JpaRepository<Subscriber, UUID> {
    @Query("SELECT s FROM Subscriber s WHERE s.id = :id")
    Subscriber findByIdCustom(@Param("id") UUID id);
}
