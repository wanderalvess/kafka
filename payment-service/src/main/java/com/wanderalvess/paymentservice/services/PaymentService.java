package com.wanderalvess.paymentservice.services;

import com.wanderalvess.paymentservice.model.Payment;

public interface PaymentService {

    void sendPayment(Payment payment);
}
