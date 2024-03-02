package com.vileladev.jsonconsumer.config;

import lombok.RequiredArgsConstructor;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.converter.JsonMessageConverter;
import org.springframework.kafka.support.converter.RecordMessageConverter;
import org.springframework.kafka.support.converter.StringJsonMessageConverter;

import java.util.HashMap;

@Configuration
@RequiredArgsConstructor
public class JsonConsumerConfig {

    private final KafkaProperties kafkaProperties;

    @Bean
    public ConsumerFactory<String, Object> jsonConsumerFactory(){
       var config = new HashMap<String, Object>();
       config.put(
               ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG,
               kafkaProperties.getBootstrapServers()
       );
       config.put(
               ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG,
               StringDeserializer.class
       );
         config.put(
                ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG,
                StringDeserializer.class
         );

        return new DefaultKafkaConsumerFactory<>(config);
    }

    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, Object> jsonContainerFactory(
            ConsumerFactory<String, Object> jsonConsumerFactory,
            RecordMessageConverter jsonMessageConverter
    ) {
        ConcurrentKafkaListenerContainerFactory<String, Object> factory =
                new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(jsonConsumerFactory);
        factory.setMessageConverter(jsonMessageConverter);
        return factory;
    }

    @Bean
    public RecordMessageConverter jsonMessageConverter() {
        return new StringJsonMessageConverter();
    }
}
