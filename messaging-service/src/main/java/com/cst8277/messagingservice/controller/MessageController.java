package com.cst8277.messagingservice.controller;

import com.cst8277.messagingservice.client.UserManagementClient;
import com.cst8277.messagingservice.entity.Message;
import com.cst8277.usermanagementservice.entity.UserRole;
import com.cst8277.messagingservice.handler.CustomErrorResponse;
import com.cst8277.messagingservice.handler.CustomException;
import com.cst8277.messagingservice.repository.MessageRepository;
import com.cst8277.messagingservice.service.MessageService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/ms/message")
public class MessageController {
    private static final Logger LOGGER
            = LoggerFactory.getLogger(MessageRepository.class);
    @Autowired
    private UserManagementClient userManagementClient;

    @Autowired
    private MessageService messageService;

    @PostMapping("/produce/{userId}")
    public ResponseEntity<?> saveMessage(
            @PathVariable("userId") UUID userId,
            @RequestBody Message message) {
        LOGGER.info("Message add: {}", message);
        List<UserRole> userRoles = userManagementClient.findByIdCustom(userId);
        boolean isProducer = userRoles.stream()
                .anyMatch(userRole -> "eb932dbb-7005-422f-a649-7190af39e984"
                        .equals(userRole.getUserRoleId().getRoles_id().toString()));
        if (isProducer) {

            Message savedMessage = messageService.saveMessage(message);
            return new ResponseEntity<>(savedMessage, HttpStatus.CREATED);
        } else {

            return new ResponseEntity<>("Access Denied: User is not a producer or is not found.", HttpStatus.FORBIDDEN);
        }
    }

    @PostMapping("/")
    public Message saveMessage(@RequestBody Message message){
        return messageService.saveMessage(message);
    }

    @GetMapping("/")
    public ResponseEntity<Object> findAll() {
        LOGGER.info("Find all messages");
        List<Message> messages = messageService.findAll();
        CustomErrorResponse response = new CustomErrorResponse
                (Integer.toString(HttpStatus.OK.value()), messages, "All messages successfully retrieved");
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("delete/{id}")
    public Optional<Message> deleteById(@PathVariable("id") UUID id) {
        LOGGER.info("Message delete: {}", id);
        return messageService.deleteById(id);
    }
    @PutMapping("/update/{id}")

    public Optional<Message> updateMessage(@PathVariable("id") UUID id, @RequestBody Message updatedMessage){
        LOGGER.info("Message update: {}", id);
        return messageService.updateMessage(id, updatedMessage);
    }
    @GetMapping("/id/{id}")
    public Message findByIdCustom(@PathVariable("id") UUID id){
        LOGGER.info("Find message: {}", id);
        return messageService.findByIdCustom(id);

    }
    @GetMapping("/content/{content}")
    public Message findByContent(@PathVariable("content") String content){
        LOGGER.info("Find message: {}", content);
        return messageService.findByContent(content);
    }
    @GetMapping("/by_producer/{producer_id}")
    public ResponseEntity<Object> findByProducerId(@PathVariable("producer_id") String producer_id){
        LOGGER.info("Find message by producer: {}", producer_id);
        UUID prodId;
        try {
            prodId = UUID.fromString(producer_id);
        }catch (IllegalArgumentException e) {
            throw new CustomException(HttpStatus.BAD_REQUEST, "Invalid producer UUID");
        }
        List<Message> message = messageService.findByProducerId(prodId);
        if (message != null && message.isEmpty()) {
            throw new CustomException(HttpStatus.NOT_FOUND, "Producer's message not found or doesn't exist");
        }
        CustomErrorResponse response = new CustomErrorResponse
                (Integer.toString(HttpStatus.OK.value()), message, "Producer's messages successfully retrieved");
        return ResponseEntity.ok(response);
    }


    @GetMapping("/for_subscriber/{subscriber_id}")
    public ResponseEntity<Object> findMessageForSubscriber(@PathVariable("subscriber_id") String subscriber_id){
        LOGGER.info("Find All Messages For Subscriber: {}", subscriber_id);
        UUID subId;
        try {
            subId = UUID.fromString(subscriber_id);
        }catch (IllegalArgumentException e) {
            throw new CustomException(HttpStatus.BAD_REQUEST, "Invalid subscriber UUID");
        }
        List<Message> message = messageService.findMessageForSubscriber(subId);
        if (message != null && message.isEmpty()) {
            throw new CustomException(HttpStatus.NOT_FOUND, "Messages for subscriber not found or doesn't exist");

        }
        CustomErrorResponse response = new CustomErrorResponse
                (Integer.toString(HttpStatus.OK.value()), message, "Messages for subscriber successfully retrieved");
        return ResponseEntity.ok(response);
    }

}
