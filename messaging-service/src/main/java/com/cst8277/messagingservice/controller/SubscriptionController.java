package com.cst8277.messagingservice.controller;

import com.cst8277.messagingservice.entity.Subscription;
import com.cst8277.messagingservice.service.SubscriptionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/ms/subscription")
public class SubscriptionController {
    private static final Logger LOGGER = LoggerFactory.getLogger(SubscriptionController.class);


    @Autowired
    private SubscriptionService subscriptionService;

    @PostMapping("/")
    public Subscription saveSubscription(@RequestBody Subscription subscription) {
        LOGGER.info("Subscription add: {}", subscription);
        return subscriptionService.saveSubscription(subscription);
    }
    @GetMapping("/")
    public List<Subscription> findAll(){
        LOGGER.info("Subscription List");
        return subscriptionService.findAll();
    }
    @GetMapping("/subscriber/{subscribers_id}")
    public List<Subscription> findBySubscriberId(@PathVariable("subscribers_id") UUID subscribers_id){
        LOGGER.info("Subscriptions for subscriber: {}", subscribers_id);
        return subscriptionService.findBySubscriberId(subscribers_id);
    }
    @DeleteMapping("/delete/subscriber/{subscribers_id}/producer/{producers_id}")
    public Subscription deleteSubscription(@PathVariable("subscribers_id") UUID subscribers_id, @PathVariable("producers_id") UUID producers_id){
        LOGGER.info("Subscription delete: subscribers_id={}, producers" +
                "_id={}", subscribers_id, producers_id);

        return subscriptionService.deleteSubscription(subscribers_id, producers_id);
    }
}