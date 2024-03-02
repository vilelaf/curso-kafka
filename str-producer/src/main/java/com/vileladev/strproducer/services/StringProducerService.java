package com.vileladev.strproducer.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@Log4j2
@RequiredArgsConstructor
public class StringProducerService {


    private final KafkaTemplate<String, String> kafkatemplate;

    public void sendMessage(String message){
        log.info("SEND {}",message);
        kafkatemplate.send(
           "str-topic",
           message
       /* ).addCallback(
              success -> {
                  if (success != null) {
                      log.info("Send message with success {} ", message);
                      log.info("Partition {}, Offset {}",
                              success.getRecordMetadata().partition(),
                              success.getRecordMetadata().offset());
                  }
              },
                error -> log.info("Error")*/
        );
    }
}

