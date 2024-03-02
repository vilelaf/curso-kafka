package com.vileladev.paymentservice.model;


import lombok.Getter;

import java.io.Serializable;

@Getter
public class PaymentModel implements Serializable {

    private Long id;
    private Long idUser;
    private Long idProduct;
    private String cardNumber;

}
