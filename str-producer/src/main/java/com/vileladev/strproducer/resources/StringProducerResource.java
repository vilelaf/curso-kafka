package com.vileladev.strproducer.resources;

import com.vileladev.strproducer.services.StringProducerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/producer")
@RequiredArgsConstructor
public class StringProducerResource {


    public final StringProducerService producerService;

    @PostMapping
    public ResponseEntity<?> sendMessage(
            @RequestBody String message) {
        producerService.sendMessage(message);
       return  ResponseEntity
                .status(HttpStatus.CREATED)
                .build();
    }

}
