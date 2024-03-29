package com.vileladev.strconsumer.listeners;

import com.vileladev.strconsumer.custom.StrConsumerCustomListener;
import lombok.SneakyThrows;
import lombok.extern.log4j.Log4j2;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.stereotype.Component;

@Component
@Log4j2
public class strConsumerListeners {

    @SneakyThrows
    @StrConsumerCustomListener(groupId = "group-1",
            containerFactory = "validMessageContainerFactory")
    public void create(String message) {
        if (!message.contains("valid")) {
            log.info("EXCEPTION Expected ::: Receive message{}", message);
            throw new IllegalArgumentException("Error Jimmy");
        }
        log.info("CREATE ::: Receive message{}", message);

    }

/*    @StrConsumerCustomListener(groupId = "group-2")
    public void log(String message) {
        log.info("LOG ::: Receive message{}", message);
    }

    @StrConsumerCustomListener(groupId = "group-2", containerFactory = "validMessageContainerFactory")
    public void hist(String message) {
        log.info("HIST ::: Receive message{}", message);
    }*/


}