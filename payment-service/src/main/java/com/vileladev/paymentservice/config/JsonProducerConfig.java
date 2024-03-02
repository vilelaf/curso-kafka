package com.vileladev.paymentservice.config;

import lombok.RequiredArgsConstructor;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonSerializer;

import java.io.Serializable;
import java.util.HashMap;


@Configuration
@RequiredArgsConstructor
public class JsonProducerConfig {

    private final KafkaProperties kafkaProperties;

    @Bean
    public ProducerFactory<String, Object> jsonProducerFactory(){
        var  configProps = new HashMap<String, Object>();

        configProps.put(
                ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, kafkaProperties.getBootstrapServers());
        configProps.put(
                ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        configProps.put(
                ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);
        return new DefaultKafkaProducerFactory(
                configProps, new StringSerializer(), new JsonSerializer());
    }

    @Bean
    public KafkaTemplate<String, Serializable> jsonKafkaTemplate(ProducerFactory jsonProducerFactory) {
        return new KafkaTemplate<>(jsonProducerFactory);
    }

}
