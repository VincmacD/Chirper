package com.cst8277.messagingservice.service;

import com.cst8277.messagingservice.entity.Subscriber;
import com.cst8277.messagingservice.repository.SubscriberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.UUID;

@Service
public class SubscriberService {
    @Autowired
    private SubscriberRepository subscriberRepository;
    public Subscriber saveSubscriber(Subscriber subscriber) {
        return subscriberRepository.save(subscriber);
    }

    public Subscriber findByIdCustom(UUID id) {
        return subscriberRepository.findByIdCustom(id);
    }
    @Transactional
    public Optional<Subscriber> updateSubscriber(UUID id, Subscriber updatedSubscriber) {
        Optional<Subscriber> existingSubscriber = subscriberRepository.findById(id);
        if (existingSubscriber.isPresent()){
            Subscriber subscriber = existingSubscriber.get();
            subscriber.setComment(updatedSubscriber.getComment());
            subscriberRepository.save(subscriber);
        }
        return existingSubscriber;
    }
    @Transactional
    public Optional<Subscriber> deleteById(UUID id) {
        Optional<Subscriber> subscriber= subscriberRepository.findById(id);
        subscriber.ifPresent(subscriberRepository::delete);
        return subscriber;
    }
}
