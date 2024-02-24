package com.cst8277.messagingservice.service;


import com.cst8277.messagingservice.entity.Producer;
import com.cst8277.messagingservice.repository.ProducerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class ProducerService {
    @Autowired
    private ProducerRepository producerRepository;
    public Producer saveProducer(Producer producer) {
        return producerRepository.save(producer);
    }

    public Producer findByIdCustom(UUID id) {
        return producerRepository.findByIdCustom(id);
    }

    public Optional<Producer> updateProducer(UUID id, Producer updatedProducer) {
        Optional<Producer> existingProducer = producerRepository.findById(id);
        if (existingProducer.isPresent()){
            Producer producer = existingProducer.get();
            producer.setComment(updatedProducer.getComment());
            producerRepository.save(producer);
        }
        return existingProducer;
    }

    public Optional<Producer> deleteProducer(UUID id) {
        Optional<Producer> producer = producerRepository.findById(id);
        producer.ifPresent(producerRepository::delete);
        return producer;
    }
}
