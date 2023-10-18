package com.wanderalvess.paymentservice.resource.impl;

import com.wanderalvess.paymentservice.model.Payment;
import com.wanderalvess.paymentservice.resource.PaymentResource;
import com.wanderalvess.paymentservice.services.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/payments")
public class PaymentResourceImpl implements PaymentResource {
    @Autowired
    private PaymentService paymentService;

    @Override
    public ResponseEntity<Payment> payment(Payment payment) throws InterruptedException {
        paymentService.sendPayment(payment);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }


    public PaymentService getPaymentService() {
        return paymentService;
    }

    public void setPaymentService(PaymentService paymentService) {
        this.paymentService = paymentService;
    }
}
