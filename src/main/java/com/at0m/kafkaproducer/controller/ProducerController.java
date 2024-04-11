package com.at0m.kafkaproducer.controller;

import com.at0m.kafkaproducer.kafka.KafkaProducer;
import com.at0m.kafkaproducer.model.KafkaMessage;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class ProducerController {

    private final KafkaProducer producer;
    @PostMapping("/produceMessage")
    public ResponseEntity<String> sendMessage(@RequestBody KafkaMessage kafkaMessage) {
        producer.publish(kafkaMessage.toString());
        return ResponseEntity.ok("Message successfully published");
    }
}
