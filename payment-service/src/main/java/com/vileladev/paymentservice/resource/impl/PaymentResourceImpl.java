package com.vileladev.paymentservice.resource.impl;

import com.vileladev.paymentservice.model.PaymentModel;
import com.vileladev.paymentservice.resource.PaymentResource;
import com.vileladev.paymentservice.service.impl.PaymentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/payments")
public class PaymentResourceImpl implements PaymentResource {

    @Autowired
    private PaymentServiceImpl paymentServiceImpl;

    @Override
    public ResponseEntity<?> sendPayment(PaymentModel payment) {
        paymentServiceImpl.sendPayment(payment);
        return ResponseEntity.status(201).build();
    }
}
