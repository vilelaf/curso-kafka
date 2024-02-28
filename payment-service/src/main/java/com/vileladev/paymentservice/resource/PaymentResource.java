package com.vileladev.paymentservice.resource;

import com.vileladev.paymentservice.model.PaymentModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public interface PaymentResource {

    @PostMapping
    public ResponseEntity<?> sendPayment(
            @RequestBody PaymentModel payment);
}
