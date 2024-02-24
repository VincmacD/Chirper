package com.cst8277.messagingservice.service;

import com.cst8277.messagingservice.entity.Message;
import com.cst8277.messagingservice.repository.MessageRepository;
import com.netflix.discovery.converters.Auto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


@Service
public class MessageService {
    @Autowired
    private MessageRepository messageRepository;

    public Message saveMessage(Message message) {
        return messageRepository.save(message);
    }

    public List<Message> findAll() {
        return messageRepository.findAll();
    }

    public Optional<Message> deleteById(UUID id) {
        Optional<Message> message = messageRepository.findById(id);
        message.ifPresent(messageRepository::delete);
        return message;
    }

    public Optional<Message> updateMessage(UUID id, Message updatedMessage) {
        Optional<Message> existingMessage = messageRepository.findById(id);
        if (existingMessage.isPresent()) {
            Message message = existingMessage.get();
            message.setContent(updatedMessage.getContent());
            messageRepository.save(message);
        }
        return existingMessage;
    }

    public Message findByIdCustom(UUID id) {
        return messageRepository.findByIdCustom(id);
    }

    public Message findByContent(String content) {
        return messageRepository.findByContent(content);
    }

    public List<Message> findByProducerId(UUID producer_id) {
        return messageRepository.findByProducerId(producer_id);
    }

    public List<Message> findMessageForSubscriber(UUID subscriber_id) {
        return messageRepository.findMessageForSubscriber(subscriber_id);
    }
}

