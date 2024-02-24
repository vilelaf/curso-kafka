package com.vileladev.strproducer.config;

import lombok.RequiredArgsConstructor;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;

import java.util.HashMap;
import java.util.Objects;

@Configuration
@RequiredArgsConstructor
public class StringProducerFactoryConfig {

    private final KafkaProperties properties;

    @Bean
    public ProducerFactory<String, String> producerFactory(){
        var configs = new HashMap<String, Object>();
        configs.put(
                //Configuracoes do servidor
                ProducerConfig
                        .BOOTSTRAP_SERVERS_CONFIG
                        ,properties.getBootstrapServers()
        );
        configs.put(
                //Configuracoes de chave
                ProducerConfig
                        .KEY_SERIALIZER_CLASS_CONFIG
                        , StringSerializer.class
        );
        configs.put(
                //Serializador do valor da classe
                ProducerConfig
                        .VALUE_SERIALIZER_CLASS_CONFIG
                        ,StringSerializer.class
        );

        return new DefaultKafkaProducerFactory<>(configs);

    }


    @Bean
    public KafkaTemplate<String, String> kafkaTemplate(){
        return new KafkaTemplate<>(producerFactory());
    }

}
