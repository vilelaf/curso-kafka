package com.vileladev.jsonconsumer.listerner;


import com.vileladev.jsonconsumer.model.PaymentModel;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.log4j.Log4j2;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Log4j2
@Component
public class JsonListener {

    @SneakyThrows
    @KafkaListener(topics = "payment-topic", groupId = "create-group", containerFactory = "jsonContainerFactory")
    public void antiFraud(@Payload PaymentModel paymentModel){
        log.info("Recebendo o pagamento {}", paymentModel.getId());
        log.info("ANTI-FRAUD ::: TESTING");
        Thread.sleep(2000);

        log.info("Compra aprovada.");
        Thread.sleep(2000);
    }

    @SneakyThrows
    @KafkaListener(topics = "payment-topic", groupId = "pdf-group", containerFactory = "jsonContainerFactory")
    public void generatePdf() {
        log.info("Gerando pdf...");
        Thread.sleep(2000);

        log.info("PDF gerado.");
        Thread.sleep(2000);
    }

    @SneakyThrows
    @KafkaListener(topics = "payment-topic", groupId = "email-group", containerFactory = "jsonContainerFactory")
    public void sendEmail() {
        log.info("Enviando email...");
        Thread.sleep(2000);

        log.info("Email enviado.");
        Thread.sleep(1000);
    }


}
