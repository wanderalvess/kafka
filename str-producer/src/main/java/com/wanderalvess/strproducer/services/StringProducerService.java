package com.wanderalvess.strproducer.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Service
public class StringProducerService {
    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public void sendMessage(String message) {
        System.out.println("Send message: " + message);
        kafkaTemplate.send("str-topic", message);
//                .addCallback(
//                success -> {
//                    if(success != null) {
//                        System.out.println("Send message:  " + message);
//                        System.out.println("Partition: " + success.getRecordMetadata().partition());
//                        System.out.println("Offset: " + success.getRecordMetadata().offset());
//                    }
//                },
//                error -> System.out.println("Error send message"));
    }

    public KafkaTemplate<String, String> getKafkaTemplate() {
        return kafkaTemplate;
    }

    public void setKafkaTemplate(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }
}
