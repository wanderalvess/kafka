package com.wanderalvess.strconsumer.exceptions;

import org.springframework.kafka.listener.KafkaListenerErrorHandler;
import org.springframework.kafka.listener.ListenerExecutionFailedException;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

@Component
public class ErrorCustomHandler implements KafkaListenerErrorHandler {
    @Override
    public Object handleError(Message<?> message, ListenerExecutionFailedException e) {
        System.out.println("EXCEPTION_HANDLER ::: CAPTUREI UM ERRO");
        System.out.println("Payload ::: " + message.getPayload());
        System.out.println("Headers ::: " + message.getHeaders());
        System.out.println("Offset ::: " + message.getHeaders().get("Kakfa_offset"));
        System.out.println("Message exception ::: " + e.getMessage());
        return null;
    }

//    @Override
//    public Object handleError(Message<?> message, ListenerExecutionFailedException exception, Consumer<?, ?> consumer) {
//        return KafkaListenerErrorHandler.super.handleError(message, exception, consumer);
//    }
}
