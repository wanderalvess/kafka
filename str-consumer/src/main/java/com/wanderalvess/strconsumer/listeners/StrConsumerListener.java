package com.wanderalvess.strconsumer.listeners;

import com.wanderalvess.strconsumer.custom.StrConsumerCustomListener;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class StrConsumerListener {
    @StrConsumerCustomListener(groupId = "group-1")
    public void listener(String message) throws Exception {
        System.out.println("CREATE ::: Receive message: " + message);
        throw new IllegalArgumentException("Exception....");
    }

    @StrConsumerCustomListener(groupId = "group-1")
    public void log (String message) {
        System.out.println("LOG ::: Receive message: " + message);
    }

    @KafkaListener(groupId = "group-2", topics = "str-topic", containerFactory = "validMessageContainerFactory")
    public void history (String message) {
        System.out.println("HISTORY ::: Receive message: " + message);
    }
}
