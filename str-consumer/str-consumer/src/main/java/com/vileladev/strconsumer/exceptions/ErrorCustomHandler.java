package com.vileladev.strconsumer.exceptions;

import lombok.extern.log4j.Log4j2;
import org.apache.kafka.clients.consumer.Consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.listener.KafkaListenerErrorHandler;
import org.springframework.kafka.listener.ListenerExecutionFailedException;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

@Component
@Log4j2
public class ErrorCustomHandler implements KafkaListenerErrorHandler {

    @Override
    public Object handleError(Message<?> message, ListenerExecutionFailedException e) {
        log.info("Content: {}", message.getPayload());
        log.info("Headers: {}", message.getHeaders());
        log.info("OFFSET: {}",message.getHeaders().get("kafka_offset"));
        log.info("TOPIC: {}",message.getHeaders().get("kafka_receivedTopic"));
        return null;
    }

/*    @Override
    public Object handleError(Message<?> message,
                              ListenerExecutionFailedException e,
                              Consumer<?,?> consumer){
        return KafkaListenerErrorHandler.super.handleError(message, e, consumer);
    }*/

}
