package com.cst8277.messagingservice.repository;

import com.cst8277.messagingservice.entity.Message;
import com.cst8277.messagingservice.entity.Subscription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;
@Repository
public interface MessageRepository extends JpaRepository<Message, UUID> {
    @Query("SELECT m FROM Message m WHERE m.id = :id")
    Message findByIdCustom(@Param("id") UUID id);

    Message findByContent(String content);

    List<Message> findByProducerId(UUID producerId);


    @Query("SELECT m FROM Message m " +
            "LEFT JOIN m.producer p " +
            "LEFT JOIN Subscription s ON s.subscriptionId.producers_id = p.id " +
            "LEFT JOIN Subscriber su ON su.id = s.subscriptionId.subscribers_id " +
            "WHERE su.id = :subscriber_id")
    List<Message> findMessageForSubscriber(@Param("subscriber_id") UUID subscriber_id);
}
