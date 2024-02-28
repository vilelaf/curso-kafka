package com.vileladev.paymentservice.model;


import lombok.Getter;

@Getter
public class PaymentModel {

    private Long id;
    private Long idUser;
    private Long idProduct;
    private String cardNumber;

}
