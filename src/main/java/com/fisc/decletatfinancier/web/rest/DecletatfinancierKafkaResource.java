package com.fisc.decletatfinancier.web.rest;

import com.fisc.decletatfinancier.service.DecletatfinancierKafkaProducer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/decletatfinancier-kafka")
public class DecletatfinancierKafkaResource {

    private final Logger log = LoggerFactory.getLogger(DecletatfinancierKafkaResource.class);

    private DecletatfinancierKafkaProducer kafkaProducer;

    public DecletatfinancierKafkaResource(DecletatfinancierKafkaProducer kafkaProducer) {
        this.kafkaProducer = kafkaProducer;
    }

    @PostMapping("/publish")
    public void sendMessageToKafkaTopic(@RequestParam("message") String message) {
        log.debug("REST request to send to Kafka topic the message : {}", message);
        this.kafkaProducer.send(message);
    }
}
