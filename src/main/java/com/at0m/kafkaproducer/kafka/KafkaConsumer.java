package com.at0m.kafkaproducer.kafka;

import com.at0m.kafkaproducer.model.KafkaMessage;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@AllArgsConstructor
public class KafkaConsumer {

    private final MongoTemplate mongoTemplate;

    @KafkaListener(topics = "at0M", groupId = "at0M")
    public void consume(String message) throws Exception {
        log.info("Message received successfully, "+message);
        KafkaMessage kafkaMessage = objectMap(message);
        saveToDb(kafkaMessage);
    }

    private void saveToDb(KafkaMessage message) {
        mongoTemplate.save(message);
    }

    private KafkaMessage objectMap(String message) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(message, KafkaMessage.class);
    }
}
