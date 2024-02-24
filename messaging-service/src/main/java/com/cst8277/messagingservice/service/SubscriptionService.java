package com.cst8277.messagingservice.service;

import com.cst8277.messagingservice.entity.Subscription;
import com.cst8277.messagingservice.entity.SubscriptionId;
import com.cst8277.messagingservice.repository.SubscriptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
public class SubscriptionService {
    @Autowired
    private SubscriptionRepository subscriptionRepository;

    @Transactional
    public Subscription saveSubscription(Subscription subscription) {
        return subscriptionRepository.save(subscription);
    }

    public List<Subscription> findBySubscriberId(UUID subscribers_id) {
        return subscriptionRepository.findBySubscriberId(subscribers_id);
    }

    public Subscription deleteSubscription(UUID subscribers_id, UUID producers_id) {
        SubscriptionId subscriptionId = new SubscriptionId(subscribers_id, producers_id);
        Subscription subscription = new Subscription(subscriptionId);
        subscriptionRepository.delete(subscription);
        return subscription;
    }

    public List<Subscription> findAll() {
        return subscriptionRepository.findAll();
    }
}
