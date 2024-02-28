package com.vileladev.paymentservice.service.impl;

import com.vileladev.paymentservice.model.PaymentModel;
import com.vileladev.paymentservice.service.PaymentService;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Service
@Log4j2
public class PaymentServiceImpl implements PaymentService {

    @Override
    public void sendPayment(PaymentModel payment) {
        log.info("Payment sent: " + payment.toString());
    }


}
