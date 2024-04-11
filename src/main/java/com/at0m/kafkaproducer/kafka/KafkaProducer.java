package com.at0m.kafkaproducer.kafka;

import com.at0m.kafkaproducer.config.Config;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Slf4j
public class KafkaProducer {

    private final KafkaTemplate<String,String> kafkaTemplate;
    private final Config config;

    public void publish(String message) {
        log.info("Sending message {}",message);
        kafkaTemplate.send(config.at0mTopic().name(),message);
        log.info("Message sent successfully");
    }
}
