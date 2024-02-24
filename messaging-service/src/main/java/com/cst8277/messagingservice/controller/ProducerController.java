package com.cst8277.messagingservice.controller;
import com.cst8277.messagingservice.entity.Producer;
import com.cst8277.messagingservice.service.ProducerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/ms/producer")
public class ProducerController {
    private static final Logger LOGGER
            = LoggerFactory.getLogger(SubscriberController.class);

    @Autowired
    private ProducerService producerService;


    @PostMapping("/")
    public Producer saveProducer(@RequestBody Producer producer) {
        LOGGER.info("Producer add: {}", producer);
        return producerService.saveProducer(producer);
    }
    @GetMapping("/id/{id}")
    public Producer findByIdCustom(@PathVariable("id") UUID id){
        LOGGER.info("Producer find: {}", id);
        return producerService.findByIdCustom(id);
    }
    @PutMapping("/update/{id}")
    public Optional<Producer> updateProducer(@PathVariable("id") UUID id, @RequestBody Producer updatedProducer){
        return producerService.updateProducer(id, updatedProducer);
    }
    @DeleteMapping("/delete/{id}")
    public Optional<Producer> deleteById(@PathVariable("id") UUID id) {
        return producerService.deleteProducer(id);
    }
}
