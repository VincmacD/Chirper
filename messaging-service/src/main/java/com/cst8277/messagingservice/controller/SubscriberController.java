package com.cst8277.messagingservice.controller;

import com.cst8277.messagingservice.entity.Subscriber;
import com.cst8277.messagingservice.service.SubscriberService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/ms/subscriber")
public class SubscriberController {
    private static final Logger LOGGER
            = LoggerFactory.getLogger(SubscriberController.class);

    @Autowired
    private SubscriberService subscriberService;


    @PostMapping("/")
    public Subscriber saveSubscriber(@RequestBody Subscriber subscriber) {
    LOGGER.info("Subscriber add: {}", subscriber);
    return subscriberService.saveSubscriber(subscriber);
    }
    @GetMapping("/id/{id}")
    public Subscriber findByIdCustom(@PathVariable("id") UUID id){
        LOGGER.info("Subscriber find: {}", id);
        return subscriberService.findByIdCustom(id);
    }
    @PutMapping("/update/{id}")
    public Optional<Subscriber> updateSubscriber(@PathVariable("id") UUID id, @RequestBody Subscriber updatedSubscriber){
        return subscriberService.updateSubscriber(id, updatedSubscriber);
    }
    @DeleteMapping("/delete/{id}")
    public Optional<Subscriber> deleteById(@PathVariable("id") UUID id) {
        return subscriberService.deleteById(id);
    }
}

