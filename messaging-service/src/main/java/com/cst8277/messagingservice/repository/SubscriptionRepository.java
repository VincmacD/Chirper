package com.cst8277.messagingservice.repository;

import com.cst8277.messagingservice.entity.Subscription;
import com.cst8277.messagingservice.entity.SubscriptionId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface SubscriptionRepository extends JpaRepository<Subscription, SubscriptionId> {
    @Query("SELECT sub FROM Subscription sub WHERE sub.subscriptionId.subscribers_id = :subscribers_id")
    List<Subscription> findBySubscriberId(UUID subscribers_id);
}
