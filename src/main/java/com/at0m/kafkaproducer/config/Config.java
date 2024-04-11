package com.at0m.kafkaproducer.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.TopicBuilder;

@EnableKafka
@Configuration
public class Config {

    @Bean
    public NewTopic at0mTopic(){
        return TopicBuilder.name("at0M")
                .build();
    }
}
